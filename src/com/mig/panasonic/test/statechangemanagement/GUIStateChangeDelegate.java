package com.mig.panasonic.test.statechangemanagement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.mig.panasonic.test.statechangemanagement.StateDefinitions.GUIEventName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

/** @author Alis
 * 
 *         Delegate class for use by GUI to bind to the state change adapter class. Its a singleton accessed through a static instance property. */

public class GUIStateChangeDelegate implements StateChangeListener {

    private static GUIStateChangeDelegate mInstance;
    private StateChangeAdapter mAdapter;
    private GUIStateChangeDelegateListener mGUIStateChangeDelegateListener;

    public interface GUIStateChangeDelegateListener {

        public void changeState(StateSetName statefulItemName, StateName newState, Object dataReference);

    }

    private GUIStateChangeDelegate() {

        this.mAdapter = StateChangeAdapter.getInstance();
        this.mAdapter.registerStateChangeListener(this);

    }

    public void registerListener(GUIStateChangeDelegateListener listener) {

        this.mGUIStateChangeDelegateListener = listener;

    }

    public static GUIStateChangeDelegate getInstance() {

        if (GUIStateChangeDelegate.mInstance == null) {
            GUIStateChangeDelegate.mInstance = new GUIStateChangeDelegate();
        }

        return GUIStateChangeDelegate.mInstance;

    }

    /** @param origin
     * @param currentGUIState
     * @param target
     * @param data
     * 
     *            Origin is the originating item containing the item that triggered the event currentGUIState is the full reported state of the GUI at
     *            the point the event was raised target is the event target i.e. an encoding of the target outcome of the event e.g. HOME data is an
     *            encapsulation of the data associated with the event required to accomplish the target outcome */
    public void setGUIEvent(StateSetName origin, HashMap<StateSetName, StateName> currentGUIStates, GUIEventName eventName, GUIEventData eventData) {

        // create bundle object
        StateChangeRequestBundle bundle = new StateChangeRequestBundle(origin, currentGUIStates, eventName, eventData);

        // send through adapter
        this.mAdapter.requestStateChange(bundle);

    }

    @Override
    public void changeState(StateChangeBundle bundle) {

        // For each state item change
        for (Iterator<?> entries = bundle.getNewGUIStates().entrySet().iterator(); entries.hasNext();) {

            Entry<StateSetName, StateName> thisEntry = (Entry<StateSetName, StateName>) entries.next();

            StateSetName statefulItemName = thisEntry.getKey();
            StateName newState = thisEntry.getValue();

            Object dataReference = bundle.getStateDataReferences().get(statefulItemName);

            // pass statechange along to the listener
            if (this.mGUIStateChangeDelegateListener != null) {
                this.mGUIStateChangeDelegateListener.changeState(statefulItemName, newState, dataReference);
            }
        }

    }

}
