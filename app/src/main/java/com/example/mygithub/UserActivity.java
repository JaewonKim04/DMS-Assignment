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
    String newString;

    static ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user3);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        avatarImg=findViewById(R.id.avatar);
        Bundle extras=getIntent().getExtras();
        newString=extras.getString("username_String");
        constraintLayout=findViewById(R.id.container);
        informationFragment=new InformationFragment();
        repositoryFragment=new RepositoryFragment();
        settingFregment=new SettingFregment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container,informationFragment).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.user:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,informationFragment).commit();
                        return true;
                    case R.id.repo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,repositoryFragment).commit();
                        return true;
                    case R.id.setting:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,settingFregment).commit();
                        return true;
                }
                return false;
            }
        });

    }

    }
