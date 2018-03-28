package com.example.aymen.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final int azerty=0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
    }
    public void photo(View view )
    {
        Intent p=new Intent();
        p.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(p,azerty);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==azerty && resultCode==RESULT_OK)
        {
            Intent i=new Intent(MainActivity.this,Main2Activity.class);
            Bundle extras=data.getExtras();
            Bitmap bitmap= (Bitmap) extras.get("data");
            //imageView.setImageBitmap(bitmap);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
            i.putExtra("image1", byteArrayOutputStream.toByteArray());
            startActivity(i);


        }

    }
}
