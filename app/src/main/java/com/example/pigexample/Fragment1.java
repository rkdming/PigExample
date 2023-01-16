package com.example.pigexample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment1 extends Fragment {

    Button startButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_1, container, false);

        startButton = rootView.findViewById(R.id.btnStart);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment2 fragment2 = new Fragment2();

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.layout1,fragment2);
                ft.commit();

            }
        });

        return rootView;


    }
}