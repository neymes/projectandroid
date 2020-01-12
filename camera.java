package com.example.myapplication11;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class camera extends AppCompatActivity {
    Button camera;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        camera=(Button)findViewById(R.id.button3);
        imageView=(ImageView)findViewById(R.id.imageView4);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent my=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(my,0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bitmap bitmap=(Bitmap)data.getExtras().get("data");
        imageView.setImageBitmap(bitmap);

    }
}
