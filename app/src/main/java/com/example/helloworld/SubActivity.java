package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SubActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_sub);
      setContentView(R.layout.activity_const);
           // setContentView(R.layout.activity_const);
        //setTitle("練習アプリ");

        TextView nameLabel= findViewById(R.id.nameLabel);
        EditText nameText=findViewById(R.id.nameText2);
        Button clearButton=findViewById(R.id.clearBottom);
        Button confirmButton=findViewById(R.id.confirmButton);
        Button sendButton=findViewById(R.id.send);

        nameLabel.setText("Name");
        sendButton.setOnClickListener(this);
        confirmButton.setOnClickListener(this);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameText.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,EventActivity.class);
        setTitle("Button Clicked");


        switch(view.getId())
        {
            case R.id.confirmButton:
                setTitle("確認Button Clicked");
                Toast.makeText(this,"確認クリック",Toast.LENGTH_SHORT).show();
                break;
            case R.id.send:
                setTitle("送信Button Clicked");
                Toast.makeText(this,"送信クリック",Toast.LENGTH_SHORT).show();
                intent.putExtra("age",19);
                startActivity(intent);
                break;
        }
    }
}
