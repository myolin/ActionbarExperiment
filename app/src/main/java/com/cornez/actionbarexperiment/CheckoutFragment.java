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

        preferences = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        double total = 0.0;

        TextView appetizerView = (TextView)getView().findViewById(R.id.textView2);
        TextView entreeView = (TextView)getView().findViewById(R.id.textView5);
        TextView dessertView = (TextView)getView().findViewById(R.id.textView9);

        TextView appetizerPriceView = (TextView)getView().findViewById(R.id.textView3);
        TextView entreePriceView = (TextView)getView().findViewById(R.id.textView7);
        TextView dessertPriceView = (TextView)getView().findViewById(R.id.textView10);

        String appetizer = preferences.getString("appetizer_name_key", null);
        String entree = preferences.getString("entree_name_key", null);
        String dessert = preferences.getString("dessert_name_key", null);

        double appetizerPrice = Double.parseDouble(preferences.getString("appetizer_price_key",null));
        double entreePrice = Double.parseDouble(preferences.getString("entree_price_key",null));
        double dessertPrice = Double.parseDouble(preferences.getString("dessert_price_key",null));

        appetizerView.setText(appetizer);
        entreeView.setText(entree);
        dessertView.setText(dessert);

        appetizerPriceView.setText("$"+appetizerPrice);
        entreePriceView.setText("$"+entreePrice);
        dessertPriceView.setText("$"+dessertPrice);

        total = appetizerPrice + entreePrice + dessertPrice;

        TextView totalView = (TextView)getView().findViewById(R.id.textView12);

        totalView.setText("$"+total);

    }
}