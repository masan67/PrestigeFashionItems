package com.marioapps.prestigefashionitems.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.marioapps.prestigefashionitems.R;

public class HomeFragment extends Fragment {

    private CardView cardViewOfertas, cardViewRopa, cardViewZapatos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_fragment, container, false);

        view.findViewById(R.id.card_ofertas).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "ofertas", Toast.LENGTH_LONG).show();
            }
        });

        return view;


    }


}
