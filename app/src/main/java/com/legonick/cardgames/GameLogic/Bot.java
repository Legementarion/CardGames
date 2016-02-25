package com.legonick.cardgames.GameLogic;

/**
 * Created by Lego on 24.02.2016.
 */
public class Bot implements Gamer {

    public int result;
    public boolean readyToPick;
    public int[] cards;
    public int cardsIndex;

    public Bot() {
        result = 0;
        readyToPick = true;
        cards = new int[11];
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
        cards[cardsIndex++] = cardId;
    }
}
