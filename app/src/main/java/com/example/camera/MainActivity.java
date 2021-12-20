package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity
{
    int CAMERA_CAPTURE;
    int CAMERA_VIDEO;
    ImageView img1;
    VideoView vid1;
    int x;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = findViewById(R.id.img);
        vid1 = findViewById(R.id.vid);
    }

    public void Clickphoto(View view) {

            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(captureIntent, CAMERA_CAPTURE);
            x = 1;
    }

    public void Clickvideo(View view) {

            Intent captureIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(captureIntent, CAMERA_VIDEO);
            x = 2;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(x){
            case(1):
            {
                Bundle extras = data.getExtras();
                Bitmap thumbnailBitmap = (Bitmap) extras.get("data");
                img1.setImageBitmap(thumbnailBitmap);
                break;
            }
            case(2):
            {
                Uri videoUri = data.getData();
                vid1.setVideoURI(videoUri);
                vid1.start();
                break;
            }
        }
    }
}