package com.legonick.cardgames.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.legonick.cardgames.Core.GameCore;
import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.R;

/**
 * Created by Lego on 24.02.2016.
 */
public class PlayActivity extends Activity {
    public GameCore game;

    ImageButton exit_button = null;
    ImageButton stop_button = null;
    ImageButton pick_button = null;
    ImageButton new_button = null;

    public ImageView[] imageViewsOfBot;
    public ImageView[] imageViewsOfUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
        exit_button = (ImageButton) findViewById(R.id.Exit);
        stop_button = (ImageButton) findViewById(R.id.Stop);
        new_button = (ImageButton) findViewById(R.id.NewGame);
        pick_button = (ImageButton) findViewById(R.id.Pick);

        Resources res = getResources();
        imageViewsOfBot = new ImageView[12];
        imageViewsOfUser = new ImageView[12];
        for (int i = 0; i < imageViewsOfUser.length; i++) {
            imageViewsOfBot[i] = (ImageView) findViewById(res.getIdentifier("b" + i, "id", this.getPackageName()));
            imageViewsOfUser[i] = (ImageView) findViewById(res.getIdentifier("p" + i, "id", this.getPackageName()));
        }

        game = GameCore.getInstance(this);
    }

    public void buttonStop(View view) {
        game.stopGame();
    }

    public void buttonExit(View view) {
        Intent playScreen = new Intent(PlayActivity.this, MainMenuActivity.class);
        startActivity(playScreen);

    }

    public void buttonNew(View view) {
        ((ImageView) findViewById(R.id.Status)).setImageResource(R.drawable.nullcard);
        game.startGame();
    }

    public void buttonPick(View view) {
        game.userPick();
    }
}
