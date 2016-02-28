package com.legonick.cardgames.Core;

import java.util.Random;

/**
 * @author Lego on 27.02.2016.
 */
public class Deck {

    static final int MIN_DECK_SIZE = 36;
    static final int MAX_DECK_SIZE = 52;

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
        initGameDeck(MIN_DECK_SIZE);
    }

    public Deck(int deckSize) {
        if (deckSize <= MIN_DECK_SIZE) {
            initGameDeck(MIN_DECK_SIZE);
            return;
        }
        initGameDeck(MAX_DECK_SIZE);

    }

    private void initGameDeck(int deckSize) {
        cards = new Card[deckSize];
        for (int i = 0, val = 1, type = 0; i < deckSize; i++, val++) {
            cards[i] = new Card(val == 5 ? (++val) : val, Types.getTypeByID(type));
            if (val == (deckSize / 4)+1) {
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
