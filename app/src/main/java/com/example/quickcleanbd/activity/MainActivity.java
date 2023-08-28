package com.example.quickcleanbd.activity;



import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quickcleanbd.R;
import com.example.quickcleanbd.fragments.HomeFragment;
import com.example.quickcleanbd.fragments.MessageFragment;
import com.example.quickcleanbd.fragments.NotificationFragment;

public class MainActivity extends AppCompatActivity {


    LinearLayout homeButton, searchButton, notificationButton, messageButton;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        homeButton = findViewById(R.id.homeButton);
        searchButton = findViewById(R.id.searchButton);
        notificationButton = findViewById(R.id.notificationButton);
        messageButton = findViewById(R.id.messageButton);


        ImageView homeIcon = findViewById(R.id.homeIcon);
        ImageView searchIcon = findViewById(R.id.searchIcon);
        ImageView notificationIcon = findViewById(R.id.notificationIcon);

        TextView homeTitle = findViewById(R.id.homeTitle);







        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, new HomeFragment());
        fragmentTransaction.commit();
        homeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loadFragment(new HomeFragment());

            }
        });

       /* searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new SearchFragment());
            }
        });


        */

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new NotificationFragment());
            }
        });

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new MessageFragment());
            }
        });


    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }






}