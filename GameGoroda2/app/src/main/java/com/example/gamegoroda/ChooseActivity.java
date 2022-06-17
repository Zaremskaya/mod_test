package com.example.gamegoroda;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }
    public void buttonTowns(View view) {
        Data data = new Data();
        if (!data.checkFiles("towns0", this))
            data.CreateFileTowns(this);
        data.deleteHistory(this);
        Intent intent = new Intent (ChooseActivity.this, GameActivity.class);
        intent.putExtra("Theme", "towns");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void buttonName (View view) {
        Data data = new Data();
        if (!data.checkFiles("names0", this))
            data.CreateFileNames(this);
        data.deleteHistory(this);
        Intent intent = new Intent (ChooseActivity.this, GameActivity.class);
        intent.putExtra("Theme", "names");
        startActivity(intent);
        overridePendingTransition(0,0);
    }
    public void buttonCountry(View view) {
        Data data = new Data();
        if (!data.checkFiles("country0", this))
            data.CreateFileCountry(this);
        data.deleteHistory(this);
        Intent intent = new Intent (ChooseActivity.this, GameActivity.class);
        intent.putExtra("Theme", "country");
        startActivity(intent);
        overridePendingTransition(0,0);

    }
}
