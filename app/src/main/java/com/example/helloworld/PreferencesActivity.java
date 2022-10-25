package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

            //アプリを情報を保存するファイルをprefに設定
        SharedPreferences pref= getPreferences(Context.MODE_PRIVATE);
            //画面のパーツを
        EditText thoughsText = findViewById(R.id.thoughsText);
        Button saveBt = findViewById(R.id.save);
        Button cancelBt = findViewById(R.id.cancel);
        Button resetBt=findViewById(R.id.reset);
        //カレーごとにプレファレンスを分ける
        String menu[]={"dry","cutlet","cheese","soup","memo"};

        //前画面からの情報を受け取る
        Intent intent = getIntent();
        int curry =intent.getIntExtra("curry",4);



        String thoughsSt = pref.getString(menu[curry],"");
        thoughsText.setText(thoughsSt);

        SharedPreferences.Editor editor= pref.edit();

        saveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(menu[curry],thoughsText.getText().toString());
               // editor.putString("memo",thoughsText.getText().toString());
                editor.apply();
                Toast.makeText(getApplicationContext(), "保存しました", Toast.LENGTH_SHORT).show();
            }
        });
        cancelBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //    Toast.makeText(getApplicationContext(), "終了します", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        resetBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("memo",null);
                editor.apply();
                Toast.makeText(getApplicationContext(), "リセットしました。", Toast.LENGTH_SHORT).show();

                thoughsText.setText(null);
            }
        });

    }
}