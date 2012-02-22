package com.mig.panasonic.statemanagement;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;

public class StateChangeBundle {

    private long mTimestamp;
    private GUI_STATE mNewState; 
    private GUIStateId mId; 
    private GUIStateData mData;
    
    public StateChangeBundle(GUI_STATE newState, GUIStateId id, GUIStateData data){
        
        this.mData = data;
        this.mId = id;
        this.mNewState = newState;
        
        this.mTimestamp = System.currentTimeMillis();
        
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public GUI_STATE getNewState() {
        return mNewState;
    }

    public GUIStateId getId() {
        return mId;
    }

    public GUIStateData getData() {
        return mData;
    }

}
