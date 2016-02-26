package com.legonick.cardgames.Core;

import android.content.res.Resources;
import android.widget.ImageView;

import com.legonick.cardgames.Activity.PlayActivity;
import com.legonick.cardgames.GameLogic.Game;
import com.legonick.cardgames.R;

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

    public int[] pick(int[] cards) {
        int size,
                image_id;
        if ((size = cards.length) == 0) {
            throw new ArithmeticException();
        }
        int index = new Random().nextInt(size);
        if (index == 4) index = size - 1;
        if (cards[index] != 0) {
            addToResult(cards[index]);
            String buf = "c" + 1 + "_" + (index + 1);
            image_id = res.getIdentifier(buf, "drawable", activity.getPackageName());
            this.cards[picked].setImageResource(image_id);
            picked++;
            System.out.println(image_id + " " + buf);
            cards[index] -= index;
        } else {
            while (true) {
                if (index == size) {
                    index = 0;
                }
                if (cards[index] != 0) {
                    addToResult(cards[index]);
                    String buf = "c" + 1 + "_" + (index + 1);
                    image_id = res.getIdentifier(buf, "drawable", activity.getPackageName());
                    this.cards[picked].setImageResource(image_id);
                    picked++;
                    System.out.println(image_id + " " + buf);
                    cards[index] -= index;
                    break;
                }
                index++;
            }
        }
        System.out.println("end picking");
        return cards;
    }


    public void setCards(ImageView[] cards) {
        this.cards = cards;
    }


}
