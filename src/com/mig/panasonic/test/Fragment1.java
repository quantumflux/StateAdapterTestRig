package com.mig.panasonic.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.mig.panasonic.statemanagement.GUIStateManager;

/**Represents a fragment in the GUI
 * 
 * @author marc.liddell
 *
 */
public class Fragment1 extends StatefulFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);
    }
    
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        Button frag1Btn = (Button) getView().findViewById(R.id.btn_show_frag2);
        frag1Btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               GUIStateManager.showFragment2();               
            }
        });
    }
    
}
