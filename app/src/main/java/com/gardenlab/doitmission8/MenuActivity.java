package com.gardenlab.doitmission8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private final int REQUEST_CODE_CLIENT=102;
    private final int REQUEST_CODE_SALES=103;
    private final int REQUEST_CODE_PRODUCT=104;
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            Toast.makeText(this, "Result from: "+requestCode, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        Intent intent = getIntent();
        Toast.makeText(this,"Request from: "+intent.getStringExtra("name").toString(),Toast.LENGTH_SHORT).show();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity1.class);
                intent.putExtra("name", "menu");
                startActivityForResult(intent,REQUEST_CODE_CLIENT);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity2.class);
                intent.putExtra("name", "menu");
                startActivityForResult(intent,REQUEST_CODE_SALES);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SubActivity3.class);
                intent.putExtra("name", "menu");
                startActivityForResult(intent,REQUEST_CODE_PRODUCT);
            }
        });

        setResult(RESULT_OK, intent);
    }
}
