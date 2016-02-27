package com.legonick.cardgames.Core;

import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.R;
import com.legonick.cardgames.Utils.EndGameEx;

/**
 * Created by Lego on 26.02.2016.
 */
public class GameCore {
    private final int WIN_STAT = 21;
    static private GameCore game;
    private PlayActivity activity;
    private Gamer user;
    private Bot bot;
    private Deck deck;

    public static GameCore getInstance(PlayActivity activity) {
        return game == null ? (game = new GameCore(activity)) : game;
    }

    public static GameCore getInstance() {
        return game == null ? (game = new GameCore()) : game;
    }

    public GameCore(PlayActivity activity) {
        this.activity = activity;
        startGame();
    }

    public GameCore() {
        startGame();
    }

    public void startGame() {
        int imgResource = R.drawable.nullcard;
        for (int i = 0; i < 12; i++) {
            activity.imageViewsOfUser[i].setImageResource(imgResource);
            activity.imageViewsOfBot[i].setImageResource(imgResource);
        }
        deck = new Deck();
        user = new Gamer(activity);
        bot = new Bot(activity);
        int i = 0;
        try {
            while (i < 2) {
                user.pick(deck);
                // TODO: 26.02.2016 activity image set
                bot.pick(deck);
                i++;
            }
        } catch (EndGameEx ex) {
            ex.printStackTrace();
        }
    }

    public void stopGame() {
        bot.doPicks(deck);
        int bot_result = WIN_STAT - bot.getResult();
        int user_result = WIN_STAT - user.getResult();


        if ((bot_result < 0) && (user_result >= 0)) {
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
            return;
        } else if (user_result < 0) {
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
            return;
        } else if (bot_result < user_result) {
            //winer bot
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
        } else {
            //winer user
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
        }
    }

    public void userPick() {
        try {
            user.pick(deck);
        } catch (EndGameEx ex) {
            // TODO: 26.02.2016 Place for new code for game with few sets
            ex.showError();
            stopGame();
        }

    }

    public Deck getDeck() {
        return deck;
    }


}
