package com.example.aymen.camera;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageView;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView= (ImageView) findViewById(R.id.imageView1);
        if (getIntent().hasExtra("image1"))
        {
           byte[] arrayOfByte = getIntent().getByteArrayExtra("image1");
            bitmap = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
            imageView.setImageBitmap(bitmap);

        }

    }
}
