package com.cornez.actionbarexperiment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class AppetizerFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_appetizer,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RadioButton choice1 = (RadioButton)getView().findViewById(R.id.radioButton1);
        RadioButton choice2 = (RadioButton)getView().findViewById(R.id.radioButton2);
        RadioButton choice3 = (RadioButton)getView().findViewById(R.id.radioButton3);
    }
}