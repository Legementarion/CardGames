package com.legonick.cardgames.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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


    public void playWithBot(View view) {
        Intent playScreen = new Intent(MainMenuActivity.this, PlayActivity.class);
        startActivity(playScreen);
    }

    public void VSPlayer(View view) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Доступно в следующем обновлении!", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void helpButton(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
        builder.setTitle(R.string.help_title)
                .setMessage(R.string.help_text)
                .setIcon(R.drawable.icon)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
