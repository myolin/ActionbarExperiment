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


public class EntreeFragment extends Fragment {

    private static final String PREF_ENTREE = "entree_key";
    private RadioGroup radioGroup;
    private SharedPreferences preferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_entree,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        preferences = this.getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        radioGroup = (RadioGroup)getView().findViewById(R.id.radio_entree);
        radioGroup.setOnCheckedChangeListener(MyListener);
        if(preferences.contains(PREF_ENTREE)){
            int id = preferences.getInt(PREF_ENTREE,-1);
            radioGroup.check(id);
        }
    }

    public RadioGroup.OnCheckedChangeListener MyListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int id = radioGroup.getCheckedRadioButtonId();
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(PREF_ENTREE, id);
            editor.commit();
            //int index = radioGroup.indexOfChild(getView().findViewById(id));
        }
    };
}