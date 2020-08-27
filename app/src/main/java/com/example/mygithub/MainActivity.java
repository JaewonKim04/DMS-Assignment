package com.example.mygithub;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    String init; //처음 id를 받는 변수
    EditText username;//이름을받는 텍스트박스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.userId);
        Button search=(Button)findViewById(R.id.search_button); //검색버튼을 인플레이션
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                             //버튼을 누르면

                init=username.getText().toString();                     //id를 입력받고
                if(init.length()>0)                                                                    //id를 입력했으면
                {
                    Intent intent =new Intent(MainActivity.this,UserActivity.class);    //명시적인탠트로
                    intent.putExtra("username_String",init);                                    //userActivity 에 username_String 키값으로 id를 넘겨준후
                    startActivity(intent);                                                             //userActivity 시작
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"id를 입력하세요",Toast.LENGTH_SHORT).show();        //아니면 다시입력하세요
                }

            }

        });
    }



}