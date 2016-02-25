package com.legonick.cardgames.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.R;

/**
 * Created by Lego on 24.02.2016.
 */
public class PlayActivity extends Activity{
    Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_activity);
//        game = new Game();
//        game.startGame();
    }

//    public void giveMeMore(View view){
//        game.userPick();
//
//    }
}
