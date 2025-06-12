package com.ottfff.game.guess.the.word;

public class GuessWordResponse {
    public final String word;
    public final Integer attempts;

    public GuessWordResponse(String word, Integer attempts) {
        this.word = word;
        this.attempts = attempts;
    }
}
