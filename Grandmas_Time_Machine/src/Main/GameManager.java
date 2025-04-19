package Main;

public class GameManager {

    ActionHandler handler = new ActionHandler(this);
    public UI ui = new UI(this);

    public static void main(String[] args) {

        new GameManager();
    }
    public GameManager() {

    }
}
