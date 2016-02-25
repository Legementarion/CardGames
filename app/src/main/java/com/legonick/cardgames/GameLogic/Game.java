package com.legonick.cardgames.GameLogic;

public class Game {

    final int[] initDeck = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10};
    int[] gameDeck;
    User user;
    Bot bot;

    public Game() {
        gameDeck = initDeck;
        user = new User();
        bot = new Bot();
    }

    public void startGame() {

        pickFirstCards();

        while (user.userPick) {
            int cardId = pickCard();
            user.addcard(pickCard());
            user.setResult(getIntValue(cardId));
        }

        while (bot.readyToPick)
            botPick();

    }

    private int getIntValue(int cardId) {
        return gameDeck[cardId];
    }

    private int pickCard() {
        int cardId = (int) (Math.random() * 36);
        if (gameDeck[cardId] == 0) {
            pickCard();
        } else {
            gameDeck[cardId] = 0;
        }
        return cardId;
    }

    private void pickFirstCards() {
        userPick();
        delay();
        userPick();
        delay();
        botPick();
        botPick();
    }

    private void userPick() {
        int cardId = pickCard();
        user.addcard(pickCard());
        user.setResult(getIntValue(cardId));
    }

    private void botPick() {
        int cardId = pickCard();
        bot.addcard(pickCard());
        bot.setResult(getIntValue(cardId));
        delay();
    }

    private void delay() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
