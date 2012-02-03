package com.mig.panasonic.test;

import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mig.panasonic.test.statechangemanagement.AppManagerStateChangeDelegate;
import com.mig.panasonic.test.statechangemanagement.AppManagerStateChangeDelegate.AppManagerStateChangeDelegateListener;
import com.mig.panasonic.test.statechangemanagement.EventData;
import com.mig.panasonic.test.statechangemanagement.GUIStateChangeDelegate;
import com.mig.panasonic.test.statechangemanagement.GUIStateChangeDelegate.GUIStateChangeDelegateListener;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions;
import com.mig.panasonic.test.statechangemanagement.EventDefinitions.EventName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateName;
import com.mig.panasonic.test.statechangemanagement.StateDefinitions.StateSetName;

public class StateAdapterTestRigActivity extends Activity implements GUIStateChangeDelegateListener, AppManagerStateChangeDelegateListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.init();
        
    }
    
    private EditText mSendEventData;
    
    private Button mSend;
    
    private TextView mOriginName;
    private TextView mEventName;
    private TextView mEventData;
    
    private TextView mNewStates;
    private TextView mDataReferences;
    
    private Button mClear;
    
    private StateName[] mStateNames;

    private GUIStateChangeDelegate mGUIDelegate;

    private AppManagerStateChangeDelegate mManagerDelegate;

    private StateSetName[] mStateSetNames;
    
    private void init(){
        
        mSendEventData = (EditText) this.findViewById(R.id.et_sendeventdata);

        mSend = (Button) this.findViewById(R.id.btn_send);
        mSend.setTag(EventName.PRIMARY_CAROUSEL);
        mSend.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                
                EventName eventName = (EventName) v.getTag();
                
                doSend(eventName);
            }
            
        });
        
        mOriginName = (TextView) this.findViewById(R.id.tv_originname);

        mEventName = (TextView) this.findViewById(R.id.tv_eventname);

        mEventData = (TextView) this.findViewById(R.id.tv_eventdata);

        
        mNewStates = (TextView) this.findViewById(R.id.tv_newstates);

        mDataReferences = (TextView) this.findViewById(R.id.tv_datareferences);
        
        mClear = (Button) this.findViewById(R.id.btn_clear);
        mClear.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                 doClear();
            }
            
        });
        
        this.mStateSetNames = StateDefinitions.StateSetName.values();
        
        this.mGUIDelegate = GUIStateChangeDelegate.getInstance();
        this.mGUIDelegate.registerListener(this);
        
        this.mManagerDelegate = AppManagerStateChangeDelegate.getInstance();
        this.mManagerDelegate.registerListener(this);
        
    }
    
    
    private void doSend(EventName eventName){
        
        int randomStateNameIndex = (int)(Math.random() * this.mStateSetNames.length);
        
        StateSetName randomOrigin = this.mStateSetNames[randomStateNameIndex];
        
        HashMap<StateSetName, StateName> guiStates = new HashMap<StateSetName, StateName>();
        guiStates.put(randomOrigin, randomOrigin.getState(0));
        
        
        EventData eventData = new EventData(mSendEventData.getText().toString());
        
        this.doClear();
        
        this.mGUIDelegate.setGUIEvent(randomOrigin, guiStates, eventName, eventData);
        
    }
    
    private void doClear(){
        
        this.mSendEventData.setText("");
        this.mOriginName.setText("");
        this.mEventName.setText("");
        this.mNewStates.setText("");
        this.mDataReferences.setText("");
        this.mEventData.setText("");
        
    }
    
    @Override
    public void changeState(StateSetName statefulItemName, StateName newState, Object dataReference) {
        
        // Extract and show data for specific GUI state change
        String currentNewStates = this.mNewStates.getText().toString();
        this.mNewStates.setText(currentNewStates + " " + statefulItemName.name() + ":" + newState.name());
        
        String currentDataRef = this.mDataReferences.getText().toString();
        this.mDataReferences.setText(currentDataRef + " " + statefulItemName.name() + ":" + dataReference.toString());
        
    }

    @Override
    public void requestStateChange(StateSetName origin, EventName event, EventData eventData) {
        
        // Extract data from bundle
        String originName = origin.name();
        this.mOriginName.setText(originName.toString());
        
        String eventName = event.name();
        this.mEventName.setText(eventName.toString());
        
        String data = eventData.getReferencedItemId();
        this.mEventData.setText(data.toString());
        
        // Set up sates and data for state change directive call - all fixed data
        HashMap<StateSetName, StateName>newGUIStates = new HashMap<StateSetName, StateName>();
        newGUIStates.put(StateSetName.CONTENT, StateName.HOME);
        newGUIStates.put(StateSetName.DASHBOARD, StateName.SHOWN);
        newGUIStates.put(StateSetName.NAVBAR, StateName.HIDDEN);
        
        HashMap<StateSetName, Object> stateDataReferences = new HashMap<StateDefinitions.StateSetName, Object>();
        stateDataReferences.put(StateSetName.CONTENT, "");
        stateDataReferences.put(StateSetName.DASHBOARD, "none");
        stateDataReferences.put(StateSetName.NAVBAR, "none");
        
        this.mManagerDelegate.setStateChangeDirective(newGUIStates, stateDataReferences);
        
    }
    
    
    
}