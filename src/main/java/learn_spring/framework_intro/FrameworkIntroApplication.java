package learn_spring.framework_intro;

import learn_spring.framework_intro.enterprise.example.web.MyWebController;
import learn_spring.framework_intro.game.GameRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FrameworkIntroApplication {

	public static void main(String[] args) {

		final ConfigurableApplicationContext context = SpringApplication.run(FrameworkIntroApplication.class, args);
		GameRunner runner = context.getBean(GameRunner.class);
		final MyWebController controller = context.getBean(MyWebController.class);
		runner.run();
		System.out.println(controller.returnValueFromBusinessService());
	}

}
