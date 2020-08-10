package com.save.zaky12rpl12018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class MainActivity extends AppCompatActivity {
CircularProgressButton circularProgressButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//for changing status bar icon colors
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
                getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                }
                setContentView(R.layout.activity_main);
                }

public void onLoginClick(View View){
        startActivity(new Intent(this,adminlog.class));
//        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

        }
    public void login(View View){
        startActivity(new Intent(this,beranda.class));
    }

        }

