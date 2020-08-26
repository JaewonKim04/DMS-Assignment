package com.example.mygithub;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mygithub.R;
import com.example.mygithub.UserActivity;


public class SettingFregment extends Fragment {

    ConstraintLayout fragment1,fragment3;
    LinearLayout fragment2;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting_fregment, container, false);
        fragment1=view.findViewById(R.id.fragment1);
        fragment2=view.findViewById(R.id.fragment2);
        fragment3=view.findViewById(R.id.fragment3);
        Bundle extras=getActivity().getIntent().getExtras();
        final String username=extras.getString("username_String");
        Button red=view.findViewById(R.id.red);
        Button yellow=view.findViewById(R.id.yellow);
        Button orange=view.findViewById(R.id.orange);
        Button blue=view.findViewById(R.id.blue);
        Button green=view.findViewById(R.id.green);
        Button white=view.findViewById(R.id.white);
        Button user=view.findViewById(R.id.button7);
        Button reset=view.findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(1);
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(2);
            }
        });
        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(3);
            }
        });
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(5);
            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(4);
            }
        });
        white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeColor(6);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/"+username));
startActivity(intent);
            }
        });
        return view;
    }
    private void changeColor(int a)
    {
        switch (a)
        {
            case 1:
                UserActivity.constraintLayout.setBackgroundColor(Color.RED);
                break;
            case 2:
                UserActivity.constraintLayout.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                UserActivity.constraintLayout.setBackgroundColor(Color.GRAY);
                break;
            case 4:
                UserActivity.constraintLayout.setBackgroundColor(Color.GREEN);
                break;
            case 5:
                UserActivity.constraintLayout.setBackgroundColor(Color.BLUE);
                break;
            case 6:
                UserActivity.constraintLayout.setBackgroundColor(Color.WHITE);
                break;

        }
    }
}