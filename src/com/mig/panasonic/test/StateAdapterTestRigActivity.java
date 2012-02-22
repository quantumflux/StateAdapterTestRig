package com.mig.panasonic.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.mig.panasonic.statemanagement.FragmentHandler;
import com.mig.panasonic.statemanagement.FragmentHandler.IFragmentTranstionManager;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATEFUL_ITEMS;
import com.mig.panasonic.statemanagement.StateDecider;

/**
 * Test Rig Activity - used to demo the flow through the state change manager
 * 
 * @author Alis
 *
 */
public class StateAdapterTestRigActivity extends FragmentActivity implements IFragmentTranstionManager {
 
    private FragmentHandler mFragmentHandler; 
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mFragmentHandler =  new FragmentHandler(this);
        
        Fragment1 frag1 = new Fragment1();
        
        frag1.setStateData(null, null);
        this.doFragmentTransition(GUI_STATEFUL_ITEMS.CONTENT, frag1, 0, 0, true);
        
        //FIXME ML -Not sure where to initialise this yet so just put it here
        StateDecider.getInstance();
    }
    
    private int getFragmentFrameId(GUI_STATEFUL_ITEMS item) {
        
        switch(item){
            case CONTENT:
                return R.id.ll_content;
            case DASHBOARD:
                
                break;
            case NAVIGATION:
                
                break;
        }
        
        return 0;
        
    }

    @Override
    public void doFragmentTransition(GUI_STATEFUL_ITEMS item, StatefulFragment newFragment, int exitAnimationId, int entryAnimationId, boolean addToBackStack) {
        
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(this.getFragmentFrameId(item), newFragment);
        
        if (entryAnimationId > 0 && exitAnimationId > 0) {
            ft.setCustomAnimations(entryAnimationId, exitAnimationId);
        } else {
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        }
        
        if (addToBackStack) ft.addToBackStack(null);
        
        ft.commit();
        ft = null;
        
    }
    
}