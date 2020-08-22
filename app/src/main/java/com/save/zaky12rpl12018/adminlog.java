package com.save.zaky12rpl12018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class adminlog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlog);

    }
    public void login(View View){
        startActivity(new Intent(this,beranda.class));
    }
    public void backcuslog(View View){
        startActivity(new Intent(this,MainActivity.class));
    }

    public void loginback(View View){
        startActivity(new Intent(this,MainActivity.class));
    }
}
