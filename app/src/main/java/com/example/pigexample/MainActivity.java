package com.example.pigexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment1 fragment1 = new Fragment1();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.layout1, fragment1);
        ft.commit();
    }
}