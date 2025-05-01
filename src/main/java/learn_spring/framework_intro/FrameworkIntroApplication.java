package learn_spring.framework_intro;

import learn_spring.framework_intro.game.GameRunner;
import learn_spring.framework_intro.game.MarioGame;
import learn_spring.framework_intro.game.PacManGame;
import learn_spring.framework_intro.game.SuperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrameworkIntroApplication {

	public static void main(String[] args) {

//		SpringApplication.run(FrameworkIntroApplication.class, args);
		MarioGame marioGame = new MarioGame();
		SuperContraGame superContraGame= new SuperContraGame();
		PacManGame pacManGame = new PacManGame();
		GameRunner runner = new GameRunner(pacManGame);
		runner.run();
	}

}
