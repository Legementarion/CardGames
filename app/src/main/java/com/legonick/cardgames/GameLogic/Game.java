package com.legonick.cardgames.GameLogic;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.R;

import java.util.Arrays;

/**
 * Created by Lego on 25.02.2016.
 */
public class Game {

    private static Game game;
    private final int WIN_STAT = 21;
    private PlayActivity activity;

    //                  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32  33  34  35
    int[] deckValues = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10};
    int[] deck = new int[36];
    int cardId;
    User user;
    Bot bot;
    private static int STEPS;

    public Game(PlayActivity activity) {
        this.activity = activity;
        user = new User(activity);
        bot = new Bot(activity);
    }

    public void startGame() {
        int imgResource = R.drawable.nullcard;
        shakeDeck();

        for (int i = 0; i < 12; i++) {
            activity.imageViewsOfUser[i].setImageResource(imgResource);
            activity.imageViewsOfBot[i].setImageResource(imgResource);
        }
        STEPS = 0;

        pickFirstCards();

        endGame();
    }

    private void shakeDeck() {
        //fill deck from 0 to 35
        for (int i = 0; i < 36; i++)
            deck[i] = i;

        //shake deck
        for (int i = 0; i < 36; i++) {
            int id = (int) (Math.random() * 36);
            int tmp = deck[i];
            deck[i] = deck[id];
            deck[id] = tmp;
        }
    }

    private int getIntValue(int cardId) {
        return deckValues[cardId];
    }

    private void pickFirstCards() {
        pick(user);
        pick(user);
        pick(bot);
        pick(bot);
    }

    private void pick(Gamer gamer) {
        gamer.addcard(deck[cardId]);
        gamer.setResult(getIntValue(deck[cardId]));
        cardId++;
    }

    public void userPick() {
        try {
            pick(user);
            STEPS++;
            if (STEPS>12) endGame();
        } catch (Exception ex) {
            // TODO: 26.02.2016 Place for new code for game with few sets
        }

    }

    public static Game getInstance(PlayActivity activity) {
        return game == null ? (game = new Game(activity)) : game;
    }

    public void setActivity(PlayActivity activity) {
        this.activity = activity;
    }

    public void endGame() {
        while (bot.readyToPick)
            pick(bot);
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

