package com.example.mygithub;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class SettingFregment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_setting_fregment, container, false);
        Bundle extras=getActivity().getIntent().getExtras();
        final String username=extras.getString("username_String");  //MainActivity 로 부터 id 전달받기
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
        });      //사용자 전환을 위해 UserActivity 끝내기
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
        });                                                     // 암시적 인텐트를 활용해서 자신의 계정이 있는 github 사이트로 이동함
        return view;
    }
    private void changeColor(int a)              //container의 색을 바꾸는 함수
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