package com.legonick.cardgames.Core;

import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.Utils.EndGameEx;

/**
 * Created by Lego on 26.02.2016.
 */
public class Bot extends Gamer {

    public Bot(PlayActivity activity) {
        super(activity);
        setCards(activity.imageViewsOfBot);
    }

    public void doPicks(Deck deck) {
        while (getResult() < 18) {
            try {
                pick(deck);
            } catch (EndGameEx endGameEx) {
                endGameEx.showError();
                GameCore.getInstance().stopGame();
            }
        }
    }

}
