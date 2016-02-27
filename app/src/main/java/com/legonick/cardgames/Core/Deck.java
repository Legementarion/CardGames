package com.legonick.cardgames.Core;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by baylrock on 27.02.2016.
 */
public class Deck {
    static final int DECK_SIZE = 36;

    public static class Card {
        int value;
        /**
         * type = 0;  -  Трефы
         * type = 1;  -  Черви
         * type = 2;  -  Пики
         * type = 3;  -  Бубны
         */
        Types type;

        Card(int value, Types type) {
            this.value = value;
            this.type = type;
        }

        @Override
        public String toString() {
            return "type = " + type + " | value = " + value;
        }
    }

    private Card[] cards;


    public Deck() {
        initGameDeck(DECK_SIZE);
    }

    public Deck(int deckSize) {
        if (deckSize < DECK_SIZE) {
            initGameDeck(DECK_SIZE);
            return;
        }
        initGameDeck(deckSize);
    }

    private void initGameDeck(int deckSize) {
        cards = new Card[deckSize];
        for (int i = 0, val = 1, type = 0; i < deckSize; i++, val++) {
            cards[i] = new Card(val == 5 ? (++val) : val, Types.getTypeByID(type));
            if (val == 10) {
                val = 0;
                type++;
            }
        }
        shufle();
    }

    public Card pickCard() {
        int index = new Random().nextInt(cards.length);
        Card picked = cards[index];
        System.arraycopy(cards, index + 1, cards, index, cards.length - 1 - index);
        return picked;
    }

    private void shufle() {
        Random rnd = new Random();
        for (int i = 0; i < cards.length - 1; i++) {
            int index = rnd.nextInt(cards.length);
            Card buf = cards[index];
            cards[index] = cards[i];
            cards[i] = buf;
        }
    }

    enum Types {
        Krest("0"),
        Chirv("1"),
        Pika("2"),
        Bubn("3");

        private String id;

        Types(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return id;
        }

        public static Types getTypeByID(int id) {
            for (Types type : values()) {
                if (type.toString().equals(String.valueOf(id))) {
                    return type;
                }
            }
            return null;
        }
    }


}
