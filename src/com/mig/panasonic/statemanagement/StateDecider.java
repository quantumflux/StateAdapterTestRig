package com.mig.panasonic.statemanagement;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;
import com.mig.panasonic.statemanagement.StateRequester.IStateRequestListener;

public class StateDecider implements IStateRequestListener {

    private static StateDecider self;

    public static StateDecider getInstance() {
        if (self == null) {
            self = new StateDecider();
        }
        return self;
    }

    private StateDecider() {
        StateRequester.registerListener(this);
    };

    @Override
    public void stateRequested(StateRequestBundle bundle) {

        /*
         * For the purposes of this test rig just reflect the request back as a change.
         * 
         * This means the cases in the switch below are going to be pretty much exactly the same.
         */

        GUI_STATE requestedState = bundle.getNewState();
        GUIStateId requestedStateId = bundle.getId();
        GUIStateData requestedStateData = bundle.getData();

        switch (requestedState) {
            case FRAGMENT1:

                StateChangeBundle f1ChangeBundle = new StateChangeBundle(requestedState, requestedStateId, requestedStateData);
                StateChangeReceiver.performStateChange(f1ChangeBundle);

                break;
            case FRAGMENT2:

                StateChangeBundle f2ChangeBundle = new StateChangeBundle(requestedState, requestedStateId, requestedStateData);
                StateChangeReceiver.performStateChange(f2ChangeBundle);

                break;
        }

    }

}
