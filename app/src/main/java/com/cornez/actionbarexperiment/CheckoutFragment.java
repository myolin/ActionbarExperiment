package com.cornez.actionbarexperiment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CheckoutFragment extends Fragment {

    private SharedPreferences preferences;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_checkout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        preferences = this.getActivity().getSharedPreferences("MyPreferenes", Context.MODE_PRIVATE);

        TextView appetizerView = (TextView)getView().findViewById(R.id.textView2);
        TextView entreeView = (TextView)getView().findViewById(R.id.textView5);
        TextView dessertView = (TextView)getView().findViewById(R.id.textView9);

        String appetizer = preferences.getString("APPETIZER_NAME", null);
        appetizerView.setText(appetizer);

    }
}