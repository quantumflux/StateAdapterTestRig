package com.mig.panasonic.statemanagement;

import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;

/** This class is a container for the methods required to trigger a state request in response to user action on the GUI
 * 
 * @author Alis */
public class GUIStateManager {

    /**
     * Transition to fragment 1
     */
    public static void showFragment1() {
        
        StateRequestBundle bundle = new StateRequestBundle(GUI_STATE.FRAGMENT1, null, null);
        StateRequester.requestStateChange(bundle);
    }
    
    /**
     * Transition to fragment 2
     */
    public static void showFragment2() {
        
        StateRequestBundle bundle = new StateRequestBundle(GUI_STATE.FRAGMENT2, null, null);
        StateRequester.requestStateChange(bundle);
    }
    
    /**
     * Call this to show main carousel
     */
    public static void showMainCarousel() {
        
        //StateRequestBundle bundle = new StateRequestBundle(GUI_STATE.SHOW_MAIN_CAROUSEL, null, null);
        //StateRequester.requestStateChange(bundle);
    }

    /**
     * Call this to show a secondary carousel list 
     * 
     * @param id GUIStateId the identifier of the secondary carousel list to show
     */
    public static void showList(GUIStateId id) {
        
        //StateRequestBundle bundle = new StateRequestBundle(GUI_STATE.SHOW_LIST, id, null);
        //StateRequester.requestStateChange(bundle);

    }
    
    
    

}
