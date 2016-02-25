package com.legonick.cardgames.GameLogic;

public class SmartBot implements Gamer {

    public int result;
    public boolean readyToPick;
    public int[] cards;
    public int cardsIndex;

    public SmartBot() {
        result = 0;
        readyToPick = true;
        cards = new int[11];
        cardsIndex = 0;
    }

    @Override
    public void setResult(int cardValue) {
        result += cardValue;
        if (analyze())
            readyToPick = false;
    }

    @Override
    public void addcard(int cardId) {
        cards[cardsIndex++] = cardId;
    }

    private boolean analyze() {

        return true;
    }
}
