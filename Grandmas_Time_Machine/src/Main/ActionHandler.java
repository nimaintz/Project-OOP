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
        System.out.println("Button clicked!");
        //TODO
    }
}
