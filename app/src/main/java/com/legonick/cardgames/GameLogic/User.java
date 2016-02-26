package com.legonick.cardgames.GameLogic;

import android.content.res.Resources;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;

/**
 * Created by Lego on 24.02.2016.
 */
public class User implements Gamer {

    public int result;
    private ImageView[] cards;
    public int cardsIndex;
    private Resources res;
    private PlayActivity activity;

    public User(PlayActivity activity) {
        this.activity = activity;
        result = 0;
        cards = activity.imageViewsOfUser;
        res = activity.getResources();
        cardsIndex = 0;
    }

    @Override
    public void setResult(int cardValue) {
        result += cardValue;
    }

    @Override
    public void addcard(int cardId) {
        int image_id = res.getIdentifier("c" + cardId, "newDrawable", activity.getPackageName());
        this.cards[cardsIndex++].setImageResource(image_id);
    }
}
