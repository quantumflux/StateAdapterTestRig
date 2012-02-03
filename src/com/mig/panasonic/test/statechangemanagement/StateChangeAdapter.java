package com.mig.panasonic.test.statechangemanagement;

import java.util.ArrayList;

/** @author Alis */
public class StateChangeAdapter {

    public static StateChangeAdapter mInstance;
    public ArrayList<StateChangeListener> mStateChangeListeners;
    public ArrayList<StateChangeRequestListener> mStateChangeRequestListeners;

    private StateChangeAdapter() {

        this.mStateChangeListeners = new ArrayList<StateChangeListener>();
        this.mStateChangeRequestListeners = new ArrayList<StateChangeRequestListener>();
        
    }

    public static StateChangeAdapter getInstance() {

        if (StateChangeAdapter.mInstance == null) {

            StateChangeAdapter.mInstance = new StateChangeAdapter();

        }

        return StateChangeAdapter.mInstance;

    }

    public void registerStateChangeListener(StateChangeListener listener) {

        this.mStateChangeListeners.add(listener);

    }

    public void unRegisterStateChangeListener(StateChangeListener listener) {

        this.mStateChangeListeners.remove(listener);

    }

    public void registerStateChangeRequestListener(StateChangeRequestListener listener) {

        this.mStateChangeRequestListeners.add(listener);

    }

    public void unRegisterStateChangeRequestListener(StateChangeRequestListener listener) {

        this.mStateChangeRequestListeners.remove(listener);

    }

    public synchronized void requestStateChange(StateChangeRequestBundle bundle) {

        if (bundle != null) {

            int numberOfListeners = this.mStateChangeRequestListeners.size();

            for (int i = 0; i < numberOfListeners; i++) {

                this.mStateChangeRequestListeners.get(i).stateChangeRequested(bundle);

            }

        }

    }

    public synchronized void doStateChange(StateChangeBundle bundle) {

        if (bundle != null) {

            int numberOfListeners = this.mStateChangeListeners.size();

            for (int i = 0; i < numberOfListeners; i++) {

                this.mStateChangeListeners.get(i).changeState(bundle);

            }

        }

    }

}
