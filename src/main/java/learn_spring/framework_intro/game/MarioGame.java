package learn_spring.framework_intro.game;

public class MarioGame implements Game{
    public void up() {
        System.out.println("Jump");
    }

    public void down() {
        System.out.println("Down into the hole");
    }
    public void left() {
        System.out.println("Stop");
    }

    public void right() {
        System.out.println("Accelerate");
    }
}
