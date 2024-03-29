package com.example.pokemon;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Pictures extends AppCompatActivity {

    ImageView imageview;
    Button button;
    Drawable drawable;
    Bitmap bitmap;
    String ImagePath;
    Uri URI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button)findViewById(R.id.button1);
        imageview = (ImageView)findViewById(R.id.imageView1);


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                drawable = getResources().getDrawable(R.drawable.pokemon1);

                bitmap = ((BitmapDrawable)drawable).getBitmap();

                ImagePath = MediaStore.Images.Media.insertImage(
                        getContentResolver(),
                        bitmap,
                        "demo_image",
                        "demo_image"
                );

                URI = Uri.parse(ImagePath);

                Toast.makeText(Pictures.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });

    }
}