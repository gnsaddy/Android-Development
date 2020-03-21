package com.addy.newsfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    FragmentOne fragementOne;
    Fragment_two fragementTwo;
    private ProgressDialog pd;
    int showing = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragementOne = new FragmentOne();
        fragementTwo = new Fragment_two();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.clayout,fragementOne);
        fragmentTransaction.commit();
        showing = 1;

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_WIFI_STATE}, PackageManager.PERMISSION_GRANTED);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_NETWORK_STATE}, PackageManager.PERMISSION_GRANTED);

    }
    public void switchFragments(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if( showing == 1){
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Changing Language");
            pd.setCancelable(false);
            pd.show();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    pd.dismiss();
                }
            }, 3000);
            fragmentTransaction.replace(R.id.clayout,fragementTwo);
            showing = 2;
        }
        else{
            pd = new ProgressDialog(MainActivity.this);
            pd.setMessage("Changing Language");
            pd.setCancelable(false);
            pd.show();

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    pd.dismiss();
                }
            }, 3000);
            fragmentTransaction.replace(R.id.clayout,fragementOne);
            showing=1;
        }
        fragmentTransaction.commit();
    }

}
