package com.legonick.cardgames.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.legonick.cardgames.R;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }


    public void PlayWithBot(View view) {
        Intent playScreen = new Intent(MainMenuActivity.this, PlayActivity.class);
        startActivity(playScreen);
    }

    public void VSPlayer(View view){
        Toast toast = Toast.makeText(getApplicationContext(),
                "Доступно в следующем обновлении!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
