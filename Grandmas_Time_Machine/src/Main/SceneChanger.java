package Main;

public class SceneChanger {

    GameManager gm;

    public SceneChanger(GameManager gm) {
        this.gm = gm;
    }

    public void showScene1() {
        gm.ui.showScene("Scene1");
    }

    public void showScene2() {
        gm.ui.showScene("Scene2");
    }

    public void showScene3() {
        gm.ui.showScene("Scene3");
    }
}
