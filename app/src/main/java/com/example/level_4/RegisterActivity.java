package com.example.level_4;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;




public class RegisterActivity extends AppCompatActivity {

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final SharedPreferences user = getSharedPreferences("User",MODE_APPEND);
        final SharedPreferences.Editor editor = user.edit();

        if(Build.VERSION.SDK_INT >= 21){
            View view = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE ;
            view.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.hide();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.tlb_reg);
        toolbar.setTitle("注册");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final EditText editText_namereg = (EditText) findViewById(R.id.edt_namereg);
        final EditText editText_pwreg = (EditText) findViewById(R.id.edt_pwreg);
        Button button = (Button) findViewById(R.id.bt_newreg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.putString(editText_namereg.getText().toString()+"username",editText_namereg.getText().toString());
                editor.putString(editText_namereg.getText().toString()+"userpw",editText_pwreg.getText().toString());

                if(user.contains(editText_namereg.getText().toString()+"username")){

                    Toast.makeText(RegisterActivity.this, "该用户名已被使用，请使用其他用户名", Toast.LENGTH_SHORT).show();

                }else if(editor.commit() && !user.getString(editText_namereg.getText().toString()+"username","").equals("")
                        && !user.getString(editText_namereg.getText().toString()+"userpw","").equals("") ){
                    Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);


                }else if (user.getString("User",editText_namereg.getText().toString()+"username").equals("")){

                    Toast.makeText(RegisterActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();

                }else if(user.getString("User",editText_pwreg.getText().toString()+"userpw").equals("")) {

                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
