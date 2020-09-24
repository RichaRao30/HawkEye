package com.ibm.monitoringdashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.WindowManager;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class Intro extends AppIntro {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        addSlide(AppIntroFragment.newInstance("Welcome to Monitoring Dashboard","Allows you to monitor data all at one place",R.drawable.intro_one, ContextCompat.getColor(getApplicationContext(),R.color.firstColor)));
        addSlide(AppIntroFragment.newInstance("From Charts to Tables","Monitor data in a clear and fun way",R.drawable.intro_two, ContextCompat.getColor(getApplicationContext(),R.color.secondColor)));
        addSlide(AppIntroFragment.newInstance("Amazing Features","Sim activations,recharges,exchanges and much more.",R.drawable.intro_three, ContextCompat.getColor(getApplicationContext(),R.color.thirdColor)));
        setFadeAnimation();

        sharedPreferences=getApplicationContext().getSharedPreferences("MyPreferences",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

        if(sharedPreferences!=null){
            boolean checkShared=sharedPreferences.getBoolean("checkState",false);
            if(checkShared==true){
                startActivity(new Intent(getApplicationContext(),Homepage.class));
                finish();
            }
        }
    }

    @Override
    public void onSkipPressed(Fragment currentFragment){
        super.onSkipPressed(currentFragment);
        startActivity(new Intent(getApplicationContext(),Homepage.class));
        editor.putBoolean("checkState",true).commit();
        finish();
    }

    @Override
    public void onDonePressed(Fragment currentFragment){
        super.onDonePressed(currentFragment);
        startActivity(new Intent(getApplicationContext(),Homepage.class));
        editor.putBoolean("checkState",true).commit();
        finish();
    }
}
