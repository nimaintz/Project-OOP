package Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener {

    GameManager gm;
    private ScoreTracker scoreTracker;

    public ActionHandler(GameManager gm, ScoreTracker scoreTracker) {
        this.gm = gm;
        this.scoreTracker = scoreTracker;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String action = e.getActionCommand();

        switch (action) {
            //scene1
            case "clicked fish": gm.ui.messageText.setText("Great! You found a food item."); break;
            case "clicked cheese": gm.ui.messageText.setText("You found another food item!"); break;
            case "clicked chicken": gm.ui.messageText.setText("You're doing great!"); break;
            case "clicked strawberry": gm.ui.messageText.setText("Little Pepe will not go hungry with you!"); break;

            //scene2
            case "clicked lamp": gm.ui.messageText.setText("Great! Now, can you see the glasses?"); break;
            case "clicked glasses": gm.ui.messageText.setText("You found the glasses! Now pour yourself a cup of tea. Can you spot the teapot?"); break;
            case "clicked teapot": gm.ui.messageText.setText("Good Good. Do you see some cups?"); break;
            case "clicked cups": gm.ui.messageText.setText("Super! All finished in Ancient China. Time to move on!"); break;

            //scene3
            case "clicked yarn": gm.ui.messageText.setText("Nice. While you're still here, you try to nibble a little with history and give daVinci some inspiration. Can you sopt his notebook in this mess?"); break;
            case "clicked notebook": gm.ui.messageText.setText("Now find a pencil to write for him some ideas from the future ;))"); break;
            case "clicked pencil": gm.ui.messageText.setText("Great job! You found all the missing items. Game over."); break;

            //Change scenes
            case "goScene1": gm.sceneChanger.showScene1(); break;
            case "goScene2": gm.sceneChanger.showScene2(); break;
            case "goScene3": gm.sceneChanger.showScene3(); break;

            default:
                break;
        }

        Object source = e.getSource();
        if (source instanceof JButton) {
            ((JButton) source).setEnabled(false);
        }
        if (source instanceof JButton && action.startsWith("goScene")) {
            ((JButton) source).setEnabled(true);
        }

        if (!scoreTracker.wasAlreadyClicked(action) && !action.startsWith("goScene")) {
            scoreTracker.registerClick(action);
            gm.ui.scoreText.setText("Total items found: " + gm.scoreTracker.getNrOfButtonsClicked() + "/11");
        }

        if (gm.scoreTracker.getNrOfButtonsClicked() == 11) {
            // Reset the tracker
            gm.scoreTracker.resetProgress();

            // Reset the save file (optional)
            gm.scoreTracker.saveProgressToFile("scoreTracker.txt");

            // Reset the UI display
            gm.ui.scoreText.setText("Total items found: 0/11");

            // Optionally show a win message
            gm.ui.messageText.setText("Congratulations! You finished the game. Progress has been reset.");
        }



    }
}
