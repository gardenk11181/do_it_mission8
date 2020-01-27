package com.gardenlab.doitmission8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SubActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);

        Intent intent = getIntent();
        Toast.makeText(this,"Request from: "+intent.getStringExtra("name").toString(), Toast.LENGTH_SHORT).show();

        Button btn_menu = findViewById(R.id.btn_menu);
        Button btn_home = findViewById(R.id.btn_home);

        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent,RESULT_OK);
            }
        });

        setResult(RESULT_OK, intent);
    }
}
