package Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager gm;

    public ActionHandler(GameManager gm) {
        this.gm = gm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {
            case "clicked button 1": gm.ui.messageText.setText("Clicked button 1"); break;
            case "clicked button 2": gm.ui.messageText.setText("Clicked button 2"); break;
            case "clicked button 3": gm.ui.messageText.setText("Clicked button 3"); break;
            case "clicked button 4": gm.ui.messageText.setText("Clicked button 4"); break;
            case "clicked button 5": gm.ui.messageText.setText("Clicked button 5"); break;
            case "clicked button 6": gm.ui.messageText.setText("Clicked button 6"); break;
            case "clicked button 7": gm.ui.messageText.setText("Clicked button 7"); break;
            case "clicked button 8": gm.ui.messageText.setText("Clicked button 8"); break;
            case "clicked button 9": gm.ui.messageText.setText("Clicked button 9"); break;

            //Change scenes
            case "goScene1": gm.sceneChanger.showScene1(); break;
            case "goScene2": gm.sceneChanger.showScene2(); break;
            case "goScene3": gm.sceneChanger.showScene3(); break;
        }
    }
}
