package com.legonick.cardgames.Core;

import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;

/**
 * Created by Lego on 26.02.2016.
 */
public class Bot extends Gamer {

    public Bot(PlayActivity activity) {
        super(activity);
        setCards(activity.imageViewsOfBot);
    }

    public void doPicks(int[] cards) {
        while (getResult() < 18) {
            cards = pick(cards);
        }
    }

}
