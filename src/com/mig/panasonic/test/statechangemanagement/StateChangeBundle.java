package com.mig.panasonic.test.statechangemanagement;

import java.util.HashMap;

import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

/** @author Alis */
public class StateChangeBundle {

    private long mTimeStamp;

    private HashMap<StateSetName, StateName> mNewGUIStates;

    private HashMap<StateSetName, Object> mStateDataReferences;

    public StateChangeBundle(HashMap<StateSetName, StateName> newGUIStates, HashMap<StateSetName, Object> stateDataReferences) {

        this.mTimeStamp = System.currentTimeMillis();

        this.mNewGUIStates = newGUIStates;
        this.mStateDataReferences = stateDataReferences;

    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    public HashMap<StateSetName, StateName> getNewGUIStates() {
        return mNewGUIStates;
    }

    public HashMap<StateSetName, Object> getStateDataReferences() {
        return mStateDataReferences;
    }

}