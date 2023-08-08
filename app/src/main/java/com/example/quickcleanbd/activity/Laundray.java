package com.example.quickcleanbd.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.quickcleanbd.R;
import com.example.quickcleanbd.fragments.HomeFragment;

public class Laundray extends AppCompatActivity {

    ImageView goBackHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundray);


        goBackHomeButton = findViewById(R.id.go_bak_home);

        goBackHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });





    }
















}