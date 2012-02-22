package com.mig.panasonic.statemanagement;

import android.support.v4.app.Fragment;

import com.mig.panasonic.statemanagement.GUIStateChangeNotifier.IGUIStateChangeNotifierListener;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateData;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUIStateId;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATE;
import com.mig.panasonic.statemanagement.GUIStateDefinitions.GUI_STATEFUL_ITEMS;
import com.mig.panasonic.test.Fragment1;
import com.mig.panasonic.test.Fragment2;
import com.mig.panasonic.test.StatefulFragment;

/** This object manages a set of GUI fragments and marshals state change notifications to the correct fragments
 * 
 * @author Alis */
public class FragmentHandler implements IGUIStateChangeNotifierListener {

    public interface IFragmentTranstionManager{
        
        public void doFragmentTransition(GUI_STATEFUL_ITEMS item, StatefulFragment newStatefulFragment, int exitAnimationId, int entryAnimationId, boolean addToBackStack);
    
    }
    
    private IFragmentTranstionManager mTransitionManager;
    
    public FragmentHandler(IFragmentTranstionManager transactionManager) {
        this.mTransitionManager = transactionManager;
    }

    @Override
    public void notify(GUI_STATE newState, GUIStateId id, GUIStateData data) {

        /*
         * This method marshals the state change into handler methods
         * 
         * The switch statement should be arranged to be ordered in rough order of rate of use
         */

        switch (newState) {
            /* commented out for test rig use - only has Fragment 1 and 2
            case BACK:
                this.goBack(id, data);
                break;
            case SHOW_MAIN_CAROUSEL:
                this.showMainCarousel(id, data);
                break;
            case SHOW_DETAIL:
                this.showDetail(id, data);
                break;
            case SHOW_LIST:
                this.showList(id, data);
                break;
            case SHOW_NEWS:
                this.showNews(id, data);
                break;
            case SHOW_TELEVISION:
                this.showTelevision(id, data);
                break;
            case SHOW_WEB:
                this.showWeb(id, data);
                break;
            case SHOW_WELCOME:
                this.showWelcome(id, data);
                break;
            case SHOW_USER_PREFERENCES:
                this.showUserPreferences(id, data);
                break;
            case SHOW_APP_PREFERENCES:
                this.showAppPreferences(id, data);
                break;
            case SHOW_ACTION:
                this.showAction(id, data);
                break;
            case SHOW_BASKET:
                this.showBasket(id, data);
                break;
            case SHOW_DIALOG:
                this.showDialog(id, data);
                break;
            case SHOW_XPHONE:
                this.showXPhone(id, data);
                break;
                */
            case FRAGMENT1:
                this.showFragment1(id, data);
                break;
            case FRAGMENT2:
                this.showFragment2(id, data);
                break;
            default:

        }

    }

    private void showFragment2(GUIStateId id, GUIStateData data) {
        
        Fragment2 frag2 = new Fragment2();
        frag2.setStateData(id, data);
        
        this.mTransitionManager.doFragmentTransition(GUI_STATEFUL_ITEMS.CONTENT, frag2, 0, 0, true);
    }

    private void showFragment1(GUIStateId id, GUIStateData data) {
        
        Fragment1 frag1 = new Fragment1();
        frag1.setStateData(id, data);
        
        this.mTransitionManager.doFragmentTransition(GUI_STATEFUL_ITEMS.CONTENT, frag1, 0, 0, true);
        
    }

    private void showXPhone(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here
        
    }

    private void showDialog(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showBasket(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showAction(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showAppPreferences(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showUserPreferences(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showWelcome(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showWeb(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showTelevision(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showNews(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showDetail(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showMainCarousel(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void goBack(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

    private void showList(GUIStateId id, GUIStateData data) {
        // TODO AC handler code here

    }

}
