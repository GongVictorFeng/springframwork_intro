package learn_spring.framework_intro.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    @Autowired
    private final Game game;
    public GameRunner(Game game) {
        this.game = game;
    }

    public void run() {
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
