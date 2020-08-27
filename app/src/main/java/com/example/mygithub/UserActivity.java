package com.example.mygithub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    InformationFragment informationFragment;
    RepositoryFragment repositoryFragment;
    SettingFregment settingFregment;
    ImageView avatarImg;
    String newString;                          //MainActivity 로 넘겨받은 이름을 저장하는 변수

    static ConstraintLayout constraintLayout;          //프레그먼트를 올릴 컨테이너
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user3);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        avatarImg=findViewById(R.id.avatar);
        Bundle extras=getIntent().getExtras();
        newString=extras.getString("username_String");   //키값으로 id 를 넘겨받음
        constraintLayout=findViewById(R.id.container);
        informationFragment=new InformationFragment();
        repositoryFragment=new RepositoryFragment();
        settingFregment=new SettingFregment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,informationFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {                               //바텀네비게이션바가 선택될때마다 프래그먼트를 교체
                switch(item.getItemId())
                {
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,informationFragment).commit();       //정보 프래그먼트 시작
                        return true;
                    case R.id.repo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,repositoryFragment).commit();           //레파지토리 프래그먼트 시작
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFregment).commit();                //설정 프래그먼트 시작
                        return true;
                }
                return false;
            }
        });

    }

    }
