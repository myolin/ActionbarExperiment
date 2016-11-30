package com.cornez.actionbarexperiment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class DessertFragment extends Fragment {

    private static final String PREF_DESSERT = "dessert_key";
    private static final String DESSERT_PRICE_TAG = "dessert_price_key";
    private static final String CHOCOLATE_CAKE = "2.99";
    private static final String APPLE_PIE = "3.99";
    private static final String ROOT_BEER = "3.99";
    private static final String DESSERT_NAME = "dessert_name_key";
    private RadioGroup radioGroup;
    private SharedPreferences preferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_dessert,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = this.getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        radioGroup = (RadioGroup)getView().findViewById(R.id.radio_dessert);
        radioGroup.setOnCheckedChangeListener(MyListener);
        if(preferences.contains(PREF_DESSERT)){
            int id = preferences.getInt(PREF_DESSERT,-1);
            radioGroup.check(id);
        }
    }

    public RadioGroup.OnCheckedChangeListener MyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int id = radioGroup.getCheckedRadioButtonId();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(PREF_DESSERT, id);
            int index = radioGroup.indexOfChild(getView().findViewById(id));
            switch (index){
                case 0:
                    editor.putString(DESSERT_PRICE_TAG, CHOCOLATE_CAKE);
                    editor.putString(DESSERT_NAME,"CHOCOLATE CAKE");
                    break;
                case 1:
                    editor.putString(DESSERT_PRICE_TAG, APPLE_PIE);
                    editor.putString(DESSERT_NAME,"APPLE PIE");
                    break;
                case 2:
                    editor.putString(DESSERT_PRICE_TAG, ROOT_BEER);
                    editor.putString(DESSERT_NAME,"ROOT BEER FLOAT");
                    break;
            }
            editor.commit();
        }
    };
}