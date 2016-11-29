package com.cornez.actionbarexperiment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class AppetizerFragment extends Fragment {

    private static final String PREF_APPETIZER = "appetizer_key";
    private static final String PRICE_TAG = "price_key";
    private static final String ONION_RINGS = "3.99";
    private static final String EGG_ROLL = "2.99";
    private static final String BBQ_WINGS = "4.99";
    private static final String APPETIZER_NAME = "name_key";
    private RadioGroup radioGroup;
    private SharedPreferences preferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_appetizer,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = this.getActivity().getSharedPreferences("MyPreferences",Context.MODE_PRIVATE);
        radioGroup = (RadioGroup)getView().findViewById(R.id.radio_appetizer);
        radioGroup.setOnCheckedChangeListener(MyListener);
        if(preferences.contains(PREF_APPETIZER)){
            int id = preferences.getInt(PREF_APPETIZER,-1);
            radioGroup.check(id);
        }
    }

    public RadioGroup.OnCheckedChangeListener MyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int id = radioGroup.getCheckedRadioButtonId();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(PREF_APPETIZER, id);
            int index = radioGroup.indexOfChild(getView().findViewById(id));
            switch (index){
                case 0:
                    editor.putString(PRICE_TAG, ONION_RINGS);
                    editor.putString(APPETIZER_NAME,"ONION RINGS");
                    break;
                case 1:
                    editor.putString(PRICE_TAG, EGG_ROLL);
                    editor.putString(APPETIZER_NAME,"CHINESE EGG ROLLS");
                    break;
                case 2:
                    editor.putString(PRICE_TAG, BBQ_WINGS);
                    editor.putString(APPETIZER_NAME,"HONEY BBQ WINGS");
                    break;
            }
            editor.commit();

        }
    };
}