package com.example.level_4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if(Build.VERSION.SDK_INT >= 21){
            View view = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE ;
            view.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.tlb_main);
        toolbar.setTitle("      登陆");
        setSupportActionBar(toolbar);

        Button button_register = (Button) findViewById(R.id.bt_reg);
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_toReg = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent_toReg);
            }
        });

        Button button_signin = (Button) findViewById(R.id.bt_signin);
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_signin = new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent_signin);
            }
        });

        Button button_sina = (Button) findViewById(R.id.bt_sina);
        button_sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"通过新浪微博登陆成功~",Toast.LENGTH_SHORT).show();
            }
        });

        Button button_tencent = (Button) findViewById(R.id.bt_tencent);
        button_tencent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"通过腾讯微博登陆成功~",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
