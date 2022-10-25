package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        //呼び元画面から送られてきたintent情報を入手
        Intent intent =getIntent();
        int age = intent.getIntExtra("age",25);

        //確認
        Toast.makeText(this, "年齢"+age, Toast.LENGTH_SHORT).show();

        //画面のパーツを登録

        TextView textProfile = findViewById(R.id.textProfile);
        EditText nameText=findViewById(R.id.EditText);
        EditText passText=findViewById(R.id.EditText2);
        Button clearN=findViewById(R.id.button);
        Button clearP=findViewById(R.id.button3);
        CheckBox checkBox=findViewById(R.id.checkBox);
        CheckBox checkBox2=findViewById(R.id.checkBox2);
        CheckBox checkBox3=findViewById(R.id.checkBox3);
        RadioButton radioButton5=findViewById(R.id.radioButton5);
        RadioButton radioButton4=findViewById(R.id.radioButton4);
        Button kakuninButton=findViewById(R.id.button4);

        clearN.setOnClickListener(this);
        clearP.setOnClickListener(this);
        kakuninButton.setOnClickListener(this);

        clearP.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                setTitle(passText.getText());
                return false;
            }
        });

        kakuninButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(radioButton5.isChecked()==true){
                    Toast.makeText(getApplicationContext(), R.string.app_name, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_SHORT).show();
                }
                finish();//画面消える
                return false;
            }
        });

    }

    @Override
    public void onClick(View view) {
        EditText nameText =findViewById(R.id.EditText);
        EditText passText =findViewById(R.id.EditText2);
        switch(view.getId()){
            case R.id.button:
                nameText.setText("");
                break;
            case R.id.button3:
                passText.setText("");
                setTitle(R.string.app_name);
                break;
            case R.id.button4:
                Toast.makeText(this, nameText.getText(), Toast.LENGTH_SHORT).show();
                break;
        }

    }
}