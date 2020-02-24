package com.addy.testfragement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    FragementOne fragementOne;
    FragementTwo fragementTwo;
    int showing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragementOne = new FragementOne();
        fragementTwo = new FragementTwo();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.cLayout,fragementOne);
        fragmentTransaction.commit();
        showing = 1;
    }

    public void switchFragments(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if( showing == 1){
            fragmentTransaction.replace(R.id.cLayout,fragementTwo);
            showing = 2;
        }
        else{
            fragmentTransaction.replace(R.id.cLayout,fragementOne);
            showing=1;
        }
        fragmentTransaction.commit();
    }

}
