package learn_spring.framework_intro;

import learn_spring.framework_intro.game.GameRunner;
import learn_spring.framework_intro.game.MarioGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkIntroApplication {

	public static void main(String[] args) {

//		SpringApplication.run(FrameworkIntroApplication.class, args);
		MarioGame game = new MarioGame();
		GameRunner runner = new GameRunner(game);
		runner.run();
	}

}
