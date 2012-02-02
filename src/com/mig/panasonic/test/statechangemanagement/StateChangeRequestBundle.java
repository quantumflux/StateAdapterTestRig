package com.mig.panasonic.test.statechangemanagement;

import java.util.HashMap;

import com.mig.panasonic.test.statechangemanagement.StateDefinitions.GUIEventName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

/** @author Alis */
public class StateChangeRequestBundle {

    private long mTimeStamp;

    private HashMap<StateSetName, StateName> mCurrentGUIStates;

    private StateSetName mOrigin;

    private GUIEventName mEventName;

    private GUIEventData mEventData;

    public StateChangeRequestBundle(StateSetName origin, HashMap<StateSetName, StateName> currentGUIStates, GUIEventName eventName, GUIEventData eventData) {

        this.mTimeStamp = System.currentTimeMillis();

        this.mOrigin = origin;
        this.mCurrentGUIStates = currentGUIStates;
        this.mEventName = eventName;
        this.mEventData = eventData;

    }

    public HashMap<StateSetName, StateName> getCurrentGUIStates() {
        return mCurrentGUIStates;
    }

    public long getTimeStamp() {
        return mTimeStamp;
    }

    public StateSetName getOrigin() {
        return mOrigin;
    }

    public GUIEventName getEventName() {
        return mEventName;
    }

    public GUIEventData getEventData() {
        return mEventData;
    }

}