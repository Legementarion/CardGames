package com.legonick.cardgames.Core;

import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.Utils.EndGameEx;

import java.util.Objects;

/**
 * Created by Lego on 26.02.2016.
 */
public class Bot extends Gamer {

    private StringBuffer[] pickedCards = new StringBuffer[12];

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
        showDown();
    }

    @Override
    public void addToDrawCard(Deck.Card pickedCard) {
        cards[picked].setImageResource(res.getIdentifier("shirt", "drawable", activity.getPackageName()));
        pickedCards[picked] = new StringBuffer("c" + pickedCard.type + "_" + pickedCard.value);
    }

    public void showDown() {
        for (int i = 0; i<picked; i++) {
            cards[i].setImageResource(res.getIdentifier(pickedCards[i].toString(), "drawable", activity.getPackageName()));
        }
    }
}
