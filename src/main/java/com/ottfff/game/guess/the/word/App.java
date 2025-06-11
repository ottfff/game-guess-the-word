package com.ottfff.game.guess.the.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;



public class App {
    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws IOException {
        var bytes = Files.readString(Paths.get("src/main/resources/some-book.txt"));
        log.info("File length: {}", bytes.length());
    }
}
