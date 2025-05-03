package Main;

public class GameManager {

    ScoreTracker scoreTracker = new ScoreTracker();
    ActionHandler handler = new ActionHandler(this, scoreTracker);
    public UI ui = new UI(this);
    public SceneChanger sceneChanger = new SceneChanger(this);

    public static void main(String[] args) {

        new GameManager();
    }


    public GameManager() {
        scoreTracker.loadProgressFromFile("scoreTracker.txt");
        ui.scoreText.setText("Total items found: " + scoreTracker.getNrOfButtonsClicked() + "/11");
    }
}
