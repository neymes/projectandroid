package com.example.myapplication11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class fromgallery extends AppCompatActivity {
    Button selectGallery;
    private  static final int pc=1001;
    private  static final int imagePC=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fromgallery);
        selectGallery=(Button)findViewById(R.id.fromgallery1);
        selectGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                      if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_DENIED){
                          String[] permissions={Manifest.permission.READ_EXTERNAL_STORAGE};
                          requestPermissions(permissions,pc);
                      }
                      else{
                          pickFromGallery();
                      }

                  }
                  else{
                      pickFromGallery();
                  }
            }
        });


    }

    private void pickFromGallery() {
        Intent intent =new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,imagePC);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case pc:{
                if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickFromGallery();
                }
                else {
                    Toast.makeText(this,"permission denied",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }
}
