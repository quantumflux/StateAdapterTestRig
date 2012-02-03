package com.mig.panasonic.test.statechangemanagement;

import java.util.HashMap;

import com.mig.panasonic.test.statechangemanagement.EventDefinitions.EventName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

/** @author Alis */
public class StateChangeRequestBundle {

    private long mTimeStamp;

    private HashMap<StateSetName, StateName> mCurrentGUIStates;

    private StateSetName mOrigin;

    private EventName mEventName;

    private EventData mEventData;

    public StateChangeRequestBundle(StateSetName origin, HashMap<StateSetName, StateName> currentGUIStates, EventName eventName, EventData eventData) {

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

    public EventName getEventName() {
        return mEventName;
    }

    public EventData getEventData() {
        return mEventData;
    }

}