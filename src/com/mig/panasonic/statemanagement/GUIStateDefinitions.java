package com.mig.panasonic.statemanagement;

import java.util.HashMap;

/**
 * This class encapsulates the enum and classes used to define a state
 * 
 * @author Alis
 *
 */
public class GUIStateDefinitions {

    /**
     * GUI state enum defining the different states the gui can be in
     * 
     * @author Alis
     *
     */
    public enum GUI_STATE {
        /* AC commented out as inappropriate for test rig
        SHOW_DETAIL, 
        SHOW_LIST, 
        SHOW_ACTION, 
        SHOW_WEB, 
        SHOW_APP_PREFERENCES, 
        SHOW_USER_PREFERENCES, 
        SHOW_WELCOME, 
        SHOW_NEWS, 
        SHOW_TELEVISION, 
        SHOW_DIALOG, 
        SHOW_XPHONE, 
        SHOW_BASKET, 
        SHOW_MAIN_CAROUSEL,
        BACK*/
        FRAGMENT1, //FIXME reinstate other states for application
        FRAGMENT2
    }
    
    /**
     * Wrapper class to define ids for states.
     * 
     * @author Alis
     *
     */
    public class GUIStateId{
        
        private String mId;
        
        public GUIStateId(String id){
            this.mId = id.toString();
        }

        public String getmId() {
            return mId;
        }

    }
    
    /**
     * Wrapper class to contain any extra data required to define a state
     * 
     * @author Alis
     *
     */
    public class GUIStateData{
        
        private HashMap<String, Object> mData;
        
        public GUIStateData(){
            mData = new HashMap<String, Object>();
        }

        /**
         * Add a data item
         * 
         * @param dataName String name of the data
         * @param dataItem Object the data object
         */
        public void addData(String dataName, Object dataItem){
            this.mData.put(dataName, dataItem);
        }
        
        /**
         * Retrieve a data item
         * 
         * @param dataName String name of the data item
         */
        public void getData(String dataName){
            this.mData.get(dataName);
        }
        
        /**
         * Remove a data item
         * 
         * @param dataName
         */
        public void removeData(String dataName){
            this.mData.remove(dataName);
        }
    }
    
    /**
     * A list of the stateful items that are available for change by the fragment handler
     * 
     * @author Alis
     *
     */
    public enum GUI_STATEFUL_ITEMS{
        
        DASHBOARD,
        CONTENT,
        NAVIGATION
        
    }
}
