package com.mig.panasonic.test;

import android.support.v4.app.Fragment;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;

public class StatefulFragment extends Fragment {

    protected GUIStateId mCurrentStateId;
    protected GUIStateData mCurrentStateData;
    
    public void setStateData(GUIStateId id, GUIStateData data){
        
        this.mCurrentStateId = id;
        this.mCurrentStateData = data;
        
    }
    
    
}
