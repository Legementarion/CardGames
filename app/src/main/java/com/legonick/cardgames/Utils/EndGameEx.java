package com.legonick.cardgames.Utils;

/**
 * Created by baylrock on 27.02.2016.
 */
public class EndGameEx extends Exception{
    private String error_mess = "Out of steps per game!";

    public EndGameEx(String message) {
        error_mess = message;
    }

    public EndGameEx() {
        super();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
        showError();
    }

    public void showError() {
        System.out.println(error_mess);
    }
}
