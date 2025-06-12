package com.ottfff.game.guess.the.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private static final Logger log = LoggerFactory.getLogger(Controller.class);
    private static final Game game = new Game("system");

    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String hello() {
        return "ПРИВЕТ Hello!!<br>Guess the word" + game.getCurrentWord();
    }


//    @GetMapping(value = "/info", produces = MediaType.TEXT_HTML_VALUE)
//    public String a() {
//        return game.getCurrentWord() + "<br>" + game.getFaults();
//    }

    @GetMapping(value = "/guess/{c}/info", produces = MediaType.TEXT_HTML_VALUE)
    public String guess(@PathVariable("c") String c) {
        if (c.length() != 1) throw new RuntimeException("Bad character");
        return game.guess(c.charAt(0)) + "<br>"+game.getCurrentWord() + "<br>" + game.getFaults();

    }
}
