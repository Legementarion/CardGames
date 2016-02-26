package com.legonick.cardgames.Core;

import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.R;

/**
 * Created by Lego on 26.02.2016.
 */
public class GameCore {
    private final int[] INITDECK = {4, 8, 12, 16, 24, 28, 32, 36, 40};
    private int[] gameDeck;
    private final int WIN_STAT = 21;
    private static int STEPS;
    static private GameCore game;
    private PlayActivity activity;
    private Gamer user;
    private Bot bot;

    public static GameCore getInstance(PlayActivity activity) {
        return game == null ? (game = new GameCore(activity)) : game;
    }

    public GameCore(PlayActivity activity) {
        this.activity = activity;
        startGame();
    }

    public void startGame() {
        int imgResource = R.drawable.nullcard;
        for (int i = 0; i < 12; i++) {
            activity.imageViewsOfUser[i].setImageResource(imgResource);
            activity.imageViewsOfBot[i].setImageResource(imgResource);
        }
        STEPS = 0;
        gameDeck = INITDECK;
        user = new Gamer(activity);
        bot = new Bot(activity);
        int i = 0;
        while (i < 2) {
            user.pick(gameDeck);
            // TODO: 26.02.2016 activity image set
            bot.pick(gameDeck);
            i++;
        }
    }

    public void stopGame() {
        bot.doPicks(gameDeck);
        int bot_result = WIN_STAT - bot.getResult();
        int user_result = WIN_STAT - user.getResult();

        System.out.println("BOT " + bot_result);
        System.out.println("USER " + user_result);

        if ((bot_result < 0) && (user_result >= 0)) {
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
            return;
        } else
        if (user_result < 0) {
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
            return;
        }else
        if (bot_result < user_result) {
            //winer bot
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.lose);
        } else {
            //winer user
            ((ImageView) activity.findViewById(R.id.Status)).setImageResource(R.drawable.win);
        }
    }

    public void userPick() {
        try {

            gameDeck = user.pick(gameDeck);
            STEPS++;
            if (STEPS>12) stopGame();
        } catch (Exception ex) {
            // TODO: 26.02.2016 Place for new code for game with few sets 
        }

    }


}
