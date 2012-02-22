package com.mig.panasonic.statemanagement;

import java.util.ArrayList;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;
import com.mig.panasonic.statemanagement.StateChangeReceiver.IStateChangeListener;

/** This class acts as a wrapper to the StateChangeReciever to marshal state changes and broadcast them to the registered listeners that handle the
 * states of the various parts of the GUI
 * 
 * @author Alis */
public class GUIStateChangeNotifier implements IStateChangeListener {

    public interface IGUIStateChangeNotifierListener {
        public void notify(GUI_STATE newState, GUIStateId id, GUIStateData data);
    }

    private ArrayList<IGUIStateChangeNotifierListener> mListeners;

    public GUIStateChangeNotifier() {
        this.mListeners = new ArrayList<IGUIStateChangeNotifierListener>();
    }

    /** Register a IStateChangeListener object to listen for state change requests
     * 
     * @param listener IGUIStateChangeNotifierListener to register on listener list */
    public void registerListener(IGUIStateChangeNotifierListener listener) {

        this.mListeners.add(listener);

    }

    /** Unregister a IStateChangeListener object
     * 
     * @param listener IGUIStateChangeNotifierListener to unregister from listener list */
    public void unregisterListener(IGUIStateChangeNotifierListener listener) {

        this.mListeners.remove(listener);

    }

    private void notifyListeners(StateChangeBundle bundle){
        
        synchronized (mListeners) {

            int size = mListeners.size();

            for (int i = 0; i < size; i++) {
                this.mListeners.get(i).notify(bundle.getNewState(), bundle.getId(), bundle.getData());
            }

        }
    }
    
    @Override
    public void doStateChange(StateChangeBundle bundle) {
        this.notifyListeners(bundle);
    }

}
