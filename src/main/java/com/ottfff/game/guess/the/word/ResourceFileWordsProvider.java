package com.ottfff.game.guess.the.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceFileWordsProvider {
    private final Logger log = LoggerFactory.getLogger(getClass());

    public List<String> provide(String filename) {
        String content;
        try {
            content = new String(
                    Files.readAllBytes(Paths.get("src/main/resources/" + filename)),
                    StandardCharsets.UTF_8
            );
        } catch (IOException e) {
            log.error("Caught exception", e);
            throw new RuntimeException(e);
        }
        String[] wordsArray = content
                .replaceAll("\\d", " ")
                .replaceAll("[^а-яА-ЯёЁ]", " ")
                .replaceAll("\\s+", " ")
                .toLowerCase()
                .split(" ");
        List<String> wordsList = Arrays.asList(wordsArray);
        List<String> filteredWords = wordsList.stream()
                .filter(word -> word.length() >= 4)
                .distinct()
                .collect(Collectors.toList());
        return filteredWords;
    }
}
