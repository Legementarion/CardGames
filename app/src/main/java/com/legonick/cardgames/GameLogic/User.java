package com.legonick.cardgames.GameLogic;

/**
 * Created by Lego on 24.02.2016.
 */
public class User implements Gamer {

    public int result;
    public int[] cards;
    public int cardsIndex;
    public boolean userPick;

    public User() {
        result = 0;
        cards = new int[11];
        cardsIndex = 0;
    }

    @Override
    public void setResult(int cardValue) {
        result += cardValue;
    }

    @Override
    public void addcard(int cardId) {
        cards[cardsIndex++] = cardId;
    }

    public void changeTuz() {

    }
}
