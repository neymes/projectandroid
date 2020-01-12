package com.example.myapplication11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class feel extends AppCompatActivity {
    Button notsure;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel);
        notsure =(Button)findViewById(R.id.notsurebutton);
        notsure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zee=new Intent(feel.this,takephoto.class);
                startActivity(zee);
            }
        });
    }
}
