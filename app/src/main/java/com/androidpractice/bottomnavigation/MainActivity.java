package com.androidpractice.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;

    private static final int FRAG1 = 0;
    private static final int FRAG2 = 1;
    private static final int FRAG3 = 2;
    private static final int FRAG4 = 3;
    private static final int FRAG5 = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       initView();

    }

    private void initView(){

        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(FRAG1);

        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_alarm:
                        setFrag(FRAG1);
                        break;
                    case R.id.action_camera:
                        setFrag(FRAG2);
                        break;
                    case R.id.action_flight:
                        setFrag(FRAG3);
                        break;

                }
                return true;
            }
        });


    }

    private void setFrag(int n){
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case FRAG1:
                ft.replace(R.id.main_frame,frag1);
                ft.commit();
                break;
            case FRAG2:
                ft.replace(R.id.main_frame,frag2);
                ft.commit();
                break;
            case FRAG3:
                ft.replace(R.id.main_frame,frag3);
                ft.commit();
                break;

                }

    }

}
