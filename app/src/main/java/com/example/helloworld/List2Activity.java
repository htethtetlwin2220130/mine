package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ViewAnimator;

import java.util.ArrayList;
import java.util.List;

public class List2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list2);


        Intent intentsub= new Intent(this,SubActivity.class);
        Intent intentEvent = new Intent(this,EventActivity.class);
            //画面のパーツを変数にセット
        ListView listView=findViewById(R.id.ListView);
        EditText tuikaTxt=findViewById(R.id.input);
        Button tuikaBtn=findViewById(R.id.button2);
            //１．可変長のString 配列
        ArrayList<String> dataList= new ArrayList<>();
        //２．配列セット用のアダプター宣言
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);
        //３．画面上のListViewにアダプターの配列データ表示
        listView.setAdapter(adapter);
       //データ追加ボタン
        tuikaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tT = tuikaTxt.getText().toString();

                if (!tT.equals("")) {
                    //1.追加する文字列を可変長配列に追加
                    dataList.add(tT);
                        //  2.リスト再表示
                    listView.setAdapter(adapter);
                        //3.テキストのクリア
                    tuikaTxt.setText("");
                }
            }
            });
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    switch (i%2){
                        case 1:
                            startActivity(intentEvent);
                            break;
                        case 0:
                            startActivity(intentsub);
                            break;
                    }
                }
            });


    }
}