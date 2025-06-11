package com.ottfff.game.guess.the.word;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameTest {

    @Test
    void youWin() {
        Game game = new Game("hello");
        assertThat(game.guess('h')).isEqualTo("h____");
        assertThat(game.guess('e')).isEqualTo("he___");
        assertThat(game.guess('l')).isEqualTo("hell_");
        assertThat(game.guess('l')).isEqualTo("hell_");
        assertThat(game.guess('o')).isEqualTo("hello");
    }


    @Test
    void gameOver() {
        Game game = new Game("hello");
        assertThat(game.guess('a')).isEqualTo("_____");
        assertThat(game.guess('b')).isEqualTo("_____");
        assertThat(game.guess('c')).isEqualTo("_____");
        assertThat(game.guess('d')).isEqualTo("_____");
        assertThat(game.guess('e')).isEqualTo("_e___");
        assertThat(game.guess('f')).isEqualTo("_e___");
        assertThat(game.guess('g')).isEqualTo("_e___");
        assertThat(game.guess('h')).isEqualTo("he___");
        assertThat(game.guess('i')).isEqualTo("he___");
        assertThat(game.guess('k')).isEqualTo("he___");
        assertThat(game.guess('l')).isEqualTo("hell_");
        assertThat(game.guess('m')).isEqualTo("hell_");
        assertThrows(RuntimeException.class, () -> game.guess('n'));
    }
}