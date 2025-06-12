package com.ottfff.game.guess.the.word;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ButtonController {
    private Game game = new Game();

    @GetMapping("/")
    public String showButtonPage() {
        return "button-page"; // Возвращает шаблон button-page.html
    }

    @PostMapping("/api/button-click")
    @ResponseBody
    public GuessWordResponse handleButtonClick(@RequestParam("action") String action) {
        game.guess(action.charAt(0));
        return new GuessWordResponse(game.getCurrentWord(), game.attempts());
    }

    @PostMapping("/api/generate-word")
    @ResponseBody
    public GuessWordResponse generateWord() {
        this.game = new Game();
        return new GuessWordResponse(game.getCurrentWord(), game.attempts());
    }
}