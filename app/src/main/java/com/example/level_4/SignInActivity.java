package com.example.level_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        @SuppressLint("WrongConstant") final SharedPreferences user = getSharedPreferences("User",MODE_APPEND);

        if(Build.VERSION.SDK_INT >= 21){
            View view = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE ;
            view.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.tlb_reg);
        toolbar.setTitle("用户名密码登录");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button button = (Button) findViewById(R.id.bt_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,AfterLoginPage.class);

                EditText editText_name = (EditText) findViewById(R.id.edt_namesin);
                EditText editText_passw = (EditText) findViewById(R.id.edt_pwsin);


               if(editText_name.getText().toString().equals("")){
                    Toast.makeText(SignInActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
                }else if(editText_passw.getText().toString().equals("")){
                    Toast.makeText(SignInActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else if(editText_name.getText().toString().equals(user.getString(editText_name.getText().toString()+"username",""))
                        && editText_passw.getText().toString().equals(user.getString(editText_name.getText().toString()+"userpw",""))){
                    startActivity(intent);
                }else {
                   Toast.makeText(SignInActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
}
