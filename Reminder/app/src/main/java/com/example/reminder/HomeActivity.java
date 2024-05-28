package com.example.reminder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeActivity extends AppCompatActivity {

    TextView home,yourActivity;
    ImageView notification,aboutYou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        home=findViewById(R.id.HomeFeed);
        yourActivity=findViewById(R.id.yourActivity);
        notification=findViewById(R.id.notification);
        aboutYou=findViewById(R.id.aboutYou);

        Home homeFragment = new Home();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.homeFragment, homeFragment)
                .commit();

        yourActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                YourActivity homeFragment = new YourActivity();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.homeFragment, homeFragment)
                        .commit();
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Home homeFragment = new Home();


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.homeFragment, homeFragment)
                        .commit();
            }
        });

        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                notification homeFragment = new notification();


                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.homeFragment, homeFragment)
                        .commit();
            }
        });

        aboutYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourInformation homeFragment = new yourInformation();

                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.homeFragment, homeFragment)
                        .commit();
            }
        });

    }


}