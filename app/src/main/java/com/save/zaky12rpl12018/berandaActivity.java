package com.save.zaky12rpl12018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class berandaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
    }
    public void back(View View){
        startActivity(new Intent(this, LoginActivity.class));
//        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);

    }
}
