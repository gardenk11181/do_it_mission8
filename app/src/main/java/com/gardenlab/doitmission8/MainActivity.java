package com.gardenlab.doitmission8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE_MENU = 101;

    private EditText edit_id;
    private EditText edit_pw;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            Toast.makeText(this,"Request from: "+requestCode, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_id = findViewById(R.id.edit_id);
        edit_pw = findViewById(R.id.edit_pw);

        Button btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = edit_id.getText().toString();
                String pw = edit_pw.getText().toString();

                if(!id.equals("") && !pw.equals("")) {
                    Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.putExtra("name", "main");
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                } else {
                    Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this,"Request from sub", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        restoreState();
    }

    protected void saveState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("id", edit_id.getText().toString());
        editor.putString("pw", edit_pw.getText().toString());
        editor.commit();
    }

    protected void restoreState() {
        SharedPreferences pref = getSharedPreferences("pref", Activity.MODE_PRIVATE);
        if((pref !=null) && (pref.contains("id")) && (pref.contains("pw"))) {
            String id = pref.getString("id","");
            String pw = pref.getString("pw", "");
            edit_id.setText(id);
            edit_pw.setText(pw);
        }
    }
}
