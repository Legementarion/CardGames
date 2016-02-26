package com.legonick.cardgames.GameLogic;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.R;

/**
 * Created by Lego on 25.02.2016.
 */
public class Game {

    private static Game game;
    final int[] initDeck = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10};
    private final int WIN_STAT = 21;
    int[] gameDeck;
    User user;
    Bot bot;
    PlayActivity activity;


    public Game() {
        gameDeck = initDeck;
        user = new User();
        bot = new Bot();
        startGame();
    }

    public void startGame() {

        pickFirstCards();

        while (user.userPick) {
            userPick();
        }

        while (bot.readyToPick) {
            botPick();
        }
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

    public void userPick() {
        int cardId = pickCard();
        user.addcard(cardId);
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

    public static Game getInstance() {
        return game == null ? (game = new Game()) : game;
    }

    public void setActivity(PlayActivity activity) {
        this.activity = activity;
    }

    public void endGame() {
        int bot_result = WIN_STAT - bot.result;
        int user_result = WIN_STAT - user.result;
        if ((bot_result < 0) && (user_result>= 0)) {
            ((ImageView)activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
            return;
        }
        if (user_result < 0) {
            ((ImageView)activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
            return;
        }

        if (bot_result<user_result) {
            //winer bot
            ((ImageView)activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
        } else {
            //winer user
            ((ImageView)activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
        }


    }
}

