package com.example.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IntentActivity extends AppCompatActivity {
    final int CAMERA_RESULT = 100;
    Uri imageUri;

    @Override
    protected void onActivityResult(int requestCode,int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,requestCode,data);
        if(requestCode == CAMERA_RESULT && resultCode == RESULT_OK){
//            Bitmap bitmap =data.getParcelableExtra("data");
            ImageView cameraImage =findViewById(R.id.imageButton);
//            cameraImage.setImageBitmap(bitmap);
            cameraImage.setImageURI(imageUri);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //画面上のパーツを変数にセット
        EditText SearchText = findViewById(R.id.SearchText);
        Button searchButton=findViewById(R.id.button5);
        Button cameraBt= findViewById(R.id.camera);



        cameraBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String fileName ="Training"+timestamp+"_.jpg";
                //パラメータの宣言
                ContentValues values= new ContentValues();
                values.put(MediaStore.Images.Media.TITLE,fileName);
                values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg");

                //
                imageUri =getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(intent,CAMERA_RESULT);

            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String query=SearchText.getText().toString();
                Intent intent=new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,query);
                startActivity(intent);
            }
        });

    }
}