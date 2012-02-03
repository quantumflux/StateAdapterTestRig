package com.mig.panasonic.test.statechangemanagement;

import java.util.HashMap;

import com.mig.panasonic.test.statechangemanagement.EventDefinitions.EventName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

public class AppManagerStateChangeDelegate implements StateChangeRequestListener {

    private static AppManagerStateChangeDelegate mInstance;
    private StateChangeAdapter mAdapter;
    private AppManagerStateChangeDelegateListener mListener;

    public interface AppManagerStateChangeDelegateListener {

        public void requestStateChange(StateSetName origin, EventName event, EventData eventData);

    }

    private AppManagerStateChangeDelegate() {

        this.mAdapter = StateChangeAdapter.getInstance();

        this.mAdapter.registerStateChangeRequestListener(this);

    }

    public void registerListener(AppManagerStateChangeDelegateListener listener) {

        this.mListener = listener;

    }

    public static AppManagerStateChangeDelegate getInstance() {

        if (AppManagerStateChangeDelegate.mInstance == null) {
            AppManagerStateChangeDelegate.mInstance = new AppManagerStateChangeDelegate();
        }

        return AppManagerStateChangeDelegate.mInstance;

    }

    @Override
    public void stateChangeRequested(StateChangeRequestBundle bundle) {

        if (this.mListener != null) {
            this.mListener.requestStateChange(bundle.getOrigin(), bundle.getEventName(), bundle.getEventData());
        }
    }

    public void setStateChangeDirective(HashMap<StateSetName, StateName> newGUIStates, HashMap<StateSetName, Object> stateDataReferences) {

        // Create bundle
        StateChangeBundle bundle = new StateChangeBundle(newGUIStates, stateDataReferences);

        // send through adapter
        this.mAdapter.doStateChange(bundle);

    }

}
