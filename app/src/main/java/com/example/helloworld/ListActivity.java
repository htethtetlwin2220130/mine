package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        String[] curryList ={"ドライカレー","カツカレー","チーズカレー","スープカレー"};

        //移動先の画面
        Intent PreferencesIntent=new Intent(this,PreferencesActivity.class);

        //画面上のパーツを登録
        ListView listView=findViewById(R.id.curryList);

        //配列のセット用のアダプター宣言
        ArrayAdapter<String>adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,curryList);


        //画面上のリストViewにアダプターの配列データ表示
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView)view;

                String st=(String) adapterView.getItemAtPosition(i);
               // Toast.makeText(getApplicationContext(),tv.getText(),Toast.LENGTH_SHORT).show();
               // Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
                //i：何番目を選んだか
                //Toast.makeText(getApplicationContext(),st,Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(),(String) adapterView.getItemAtPosition(i),Toast.LENGTH_SHORT).show();
                //何番目を選んだか
                PreferencesIntent.putExtra("curry",i);
                //画面移動
                startActivity(PreferencesIntent);
            }
        });
    }
}