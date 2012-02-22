package com.mig.panasonic.statemanagement;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;

public class StateRequestBundle {

    private long mTimestamp;
    private GUI_STATE mRequestedState; 
    private GUIStateId mId; 
    private GUIStateData mData;
    
    public StateRequestBundle(GUI_STATE requestedState, GUIStateId id, GUIStateData data){
        
        this.mData = data;
        this.mId = id;
        this.mRequestedState = requestedState;
        
        this.mTimestamp = System.currentTimeMillis();
        
    }

    public long getTimestamp() {
        return mTimestamp;
    }

    public GUI_STATE getNewState() {
        return mRequestedState;
    }

    public GUIStateId getId() {
        return mId;
    }

    public GUIStateData getData() {
        return mData;
    }
    
}
