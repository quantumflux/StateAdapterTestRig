package com.mig.panasonic.statemanagement;

import java.util.ArrayList;

import com.mig.panasonic.statemanagement.StateRequester.IStateRequestListener;

/**
 * This singleton class acts as to receive state change directives and broadcast them
 * to all registered listeners.
 * 
 * Any object that requires an application state change
 * calls the doStateChange method passing through a bundle defining the change
 * and this is passed through to the listeners.
 * 
 * @author Alis
 *
 */
public class StateChangeReceiver {

    /**
     * Defines the interface to be implemented by a IStateChangeListener
     * 
     * @author Alis
     *
     */
    public interface IStateChangeListener{
        /**
         * Allows a state change to be broadcast to the listener
         * 
         * @param bundle StateChangeBundle the bundle defining the state change
         */
        public void doStateChange(StateChangeBundle bundle);
    }
    
    private static ArrayList<IStateChangeListener> listeners = new ArrayList<IStateChangeListener>();
    
    private StateChangeReceiver(){
        
        listeners = new ArrayList<IStateChangeListener>();
        
    }
    
    /**
     * Called to require a state change. The bundle is broadcast to all registered listeners
     * 
     * @param bundle StateChangeBundle defining state change to broadcast to listeners
     */
    public static void requestStateChange(StateChangeBundle bundle){
        
        synchronized (listeners) {

            for (int i = 0; i < listeners.size(); i++){
                listeners.get(i).doStateChange(bundle);
            }
            
        }
        
    }
    
    /** Register a IStateChangeListener object to listen for state change requests
     * 
     * @param listener */
    public static void registerListener(IStateChangeListener listener) {

        listeners.add(listener);

    }

    /** Unregister a IStateChangeListener object
     * 
     * @param listener */
    public static void unregisterListener(IStateChangeListener listener) {

        listeners.remove(listener);

    }
    
}
