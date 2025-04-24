package Main;

public class GameManager {

    ActionHandler handler = new ActionHandler(this);
    public UI ui = new UI(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    public static void main(String[] args) {

        new GameManager();
    }
    public GameManager() {

    }
}
