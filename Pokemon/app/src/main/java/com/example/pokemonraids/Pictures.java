package com.example.pokemonraids;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Pictures extends AppCompatActivity {

    Button button;
    ImageView imageview;
    Bitmap bitmap;
    View view;
    ByteArrayOutputStream bytearrayoutputstream;
    File file;
    FileOutputStream fileoutputstream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pictures);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button)findViewById(R.id.button2);
        imageview = (ImageView)findViewById(R.id.image1);
        bytearrayoutputstream = new ByteArrayOutputStream();

        button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {
                // TODO Auto-generated method stub


                Drawable drawable = getResources().getDrawable(R.drawable.pokemon1);

                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

                bitmap.compress(Bitmap.CompressFormat.PNG, 60, bytearrayoutputstream);

                file = new File( Environment.getExternalStorageDirectory() + "/SampleImage.png");

                try

                {
                    file.createNewFile();

                    fileoutputstream = new FileOutputStream(file);

                    fileoutputstream.write(bytearrayoutputstream.toByteArray());

                    fileoutputstream.close();

                }

                catch (Exception e)

                {

                    e.printStackTrace();

                }

                Toast.makeText(Pictures.this, "Image Saved Successfully", Toast.LENGTH_LONG).show();

            }
        });
    }

}


//public class Pictures extends AppCompatActivity {
//        ImageView image;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_pictures);
//       // image = (ImageView) findViewById(R.id.image1);
//       // image = (ImageView) findViewById(R.id.image2);
//
//    }
//
//
//}
