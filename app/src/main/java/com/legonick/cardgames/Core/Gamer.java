package com.legonick.cardgames.Core;

import android.content.res.Resources;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.R;
import com.legonick.cardgames.Utils.EndGameEx;

import java.util.Random;

/**
 * Created by Lego on 25.02.2016.
 */
public class Gamer {


    private ImageView[] cards;
    private int picked = 0;
    private int result = 0;
    private PlayActivity activity;
    private Resources res;

    public Gamer(PlayActivity activity) {
        this.activity = activity;
        cards = activity.imageViewsOfUser;
        res = activity.getResources();
    }

    void setResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void addToResult(int value) {
        result += value;
    }

    public void pick(Deck deck) throws EndGameEx {
        if (picked==12) { throw  new EndGameEx();}
        Deck.Card pickedCard = deck.pickCard();
        result += pickedCard.value;
        StringBuffer buf = new StringBuffer("c" + pickedCard.type + "_" + pickedCard.value);
        this.cards[picked].setImageResource(res.getIdentifier(buf.toString(), "drawable", activity.getPackageName()));
        picked++;

    }

    public void setCards(ImageView[] cards) {
        this.cards = cards;
    }

    public PlayActivity getActivity() {
        return activity;
    }


}
