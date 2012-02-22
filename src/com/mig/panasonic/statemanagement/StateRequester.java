package com.mig.panasonic.statemanagement;

import java.util.ArrayList;

/** This singleton class acts as to receive StateRequests and broadcast them to all registered listeners.
 * 
 * Any object that generates an event that may require an application state change calls the requestStateChange method passing through a bundle
 * defining the event and this is passed through to the listeners.
 * 
 * @author Alis */
public class StateRequester {

    /** Defines the interface to be implemented by a IStateRequestListener
     * 
     * @author Alis */
    public interface IStateRequestListener {

        /** Allows a state request to be broadcast to the listener
         * 
         * @param bundle StateRequestBundle the bundle defining the request */
        public void stateRequested(StateRequestBundle bundle);
    }

    private static ArrayList<IStateRequestListener> listeners = new ArrayList<IStateRequestListener>();

    /** Called to request a state change. The bundle is broadcast to all registered listeners
     * 
     * @param bundle StateRequestBundle defining request to broadcast to listeners */
    public static void requestStateChange(StateRequestBundle bundle) {

        synchronized (listeners) {

            for (int i = 0; i < listeners.size(); i++) {
                listeners.get(i).stateRequested(bundle);
            }

        }

    }

    /** Register a IStateRequestListener object to listen for state change requests
     * 
     * @param listener */
    public static void registerListener(IStateRequestListener listener) {

        listeners.add(listener);

    }

    /** Unregister a IStateRequestListener object
     * 
     * @param listener */
    public void unregisterListener(IStateRequestListener listener) {

        listeners.remove(listener);

    }

}
