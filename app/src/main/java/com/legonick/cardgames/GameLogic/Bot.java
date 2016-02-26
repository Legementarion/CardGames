package com.legonick.cardgames.GameLogic;

import android.content.res.Resources;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;

public class Bot implements Gamer {

    public int result;
    public boolean readyToPick;
    private ImageView[] cards;
    public int cardsIndex;
    private Resources res;
    private PlayActivity activity;

    public Bot(PlayActivity activity) {
        this.activity = activity;
        result = 0;
        readyToPick = true;
        cards = activity.imageViewsOfBot;
        cardsIndex = 0;
    }

    @Override
    public void setResult(int cardValue) {
        result += cardValue;
        if (result >= 18)
            readyToPick = false;
    }

    @Override
    public void addcard(int cardId) {
        int image_id = res.getIdentifier("c" + cardId, "newDrawable", activity.getPackageName());
        this.cards[cardsIndex++].setImageResource(image_id);
    }
}