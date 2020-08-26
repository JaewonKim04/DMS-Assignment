package com.example.mygithub;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String init;
    EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.userId);
        Button search=(Button)findViewById(R.id.search_button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                init=username.getText().toString();
                if(init.length()>0)
                {
                    Intent intent =new Intent(MainActivity.this,UserActivity.class);
intent.putExtra("username_String",init);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"id를 입력하세요",Toast.LENGTH_SHORT).show();
                }

            }

        });
    }



}