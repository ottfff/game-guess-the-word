package com.ottfff.game.guess.the.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Random;

public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);

    private final String secretWord;
    private final Integer maxFaults = 10;
    private char[] currentWord;
    private Integer currentFaults = 0;

    public Game(String secretWord) {
        this.secretWord = secretWord.toLowerCase();
        this.currentWord = secretWord.replaceAll(".", "_").toCharArray();
    }

    public Game() {
        List<String> words = new ResourceFileWordsProvider().provide("some-book.txt");
        int randomIndex = new Random().nextInt(0, words.size());
        this.secretWord = words.get(randomIndex);
        this.currentWord = secretWord.replaceAll(".", "_").toCharArray();
    }

    public String getCurrentWord() {
        return new String(currentWord);
    }

    public String guess(char c) {
        log.info("Guess {}", c);
        if (secretWord.contains(c + "")) {
            for (int i = 0; i < secretWord.length(); i++) {
                char c1 = secretWord.charAt(i);
                if (c == c1) {
                    currentWord[i] = c;
                }
            }
            log.info("Word has this character!");
            log.info(getCurrentWord());
            if (!getCurrentWord().contains("_")) {
                log.info("You won!!!");
            }
        } else {
            currentFaults++;
            log.info("Word doesn't have this character. {} guesses left", maxFaults - currentFaults);
            if (currentFaults == maxFaults) {
                throw new RuntimeException("Game Over");
            }
        }
        return new String(currentWord);
    }

    public Integer attempts() {
        return maxFaults - currentFaults;
    }
}
