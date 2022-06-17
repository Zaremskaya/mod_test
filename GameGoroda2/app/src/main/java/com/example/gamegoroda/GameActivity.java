package com.example.gamegoroda;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    String theme;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        theme = intent.getStringExtra("Theme");
        switch (theme) {
            case "names":
                k = 2;
                break;
            case "towns":
                k = 29;
                break;
            case "country":
                k = 1;
                break;
        }
    }
    public void buttonSend (View view) {
        Data data = new Data();
        ((TextView)findViewById(R.id.textView4)).setText("");
        String pastText = ((TextView)findViewById(R.id.textView)).getText().toString(); //Считываем введённое программой слово
        String Message = ((EditText)findViewById(R.id.userText)).getText().toString().trim(); //Считываем введённое пользователем слово

        String lSymb = Message.substring(Message.length()-1);
        switch (lSymb) {
            case "ь":
            case "ъ":
            case "ы":
                lSymb = Message.substring(Message.length()-2, Message.length()-1);
                break;
            default:
                lSymb = lSymb.toUpperCase();
        }
        String Responce = data.confirmWord(Message, lSymb, pastText, theme, k,this);
//        textView.setText(" - Слово не может начинаться с этой буквы");
        Intent intent = new Intent(GameActivity.this, LooseActivity.class);
        switch (Responce) {
            case "IAmWin":
                intent.putExtra("Message", "ВЫ ПРОИГРАЛИ!");
                //intent.putExtra("Score", Score);
                data.deleteHistory(this);
                startActivity(intent);
                break;
            case "YouWin":
                intent.putExtra("Message", "ВЫ ВЫЙГРАЛИ!");
                //intent.putExtra("Score", Score);
                data.deleteHistory(this);
                startActivity(intent);
                break;
            default:
                ((TextView)findViewById(R.id.textView)).setText(Responce);
                ((EditText) findViewById(R.id.userText)).setText("");
        }
    }
    public void buttonDefeated(View view) {
        Intent intent = new Intent(GameActivity.this, LooseActivity.class);
        intent.putExtra("Message", "ВЫ ПРОИГРАЛИ!");
        //intent.putExtra("Score", Score);
        Data data = new Data();

        data.deleteHistory(this);

        startActivity(intent);
        //overridePendingTransition(0,0);
    }
}
