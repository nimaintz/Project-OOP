package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class UI {

    GameManager gm;
    JFrame window;
    public JTextArea messageText;
    public JPanel bgPanel[] = new JPanel[10];
    public JLabel bgLabel[] = new JLabel[10];


    public UI(GameManager gm) {
        this.gm = gm;
        createMainField();
        generateScreen();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setTitle("Grandma's Time Machine");
        window.setSize(650, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("Welcome to Grandma's Time Machine");
        messageText.setBounds(50, 410, 525, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createBackground(int bgNum, String bgFileName) {

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(40, 50, 525, 350);
        bgPanel[bgNum].setBackground(Color.blue);
        bgPanel[bgNum].setLayout(null);
        window.add(bgPanel[bgNum]);


        bgLabel[bgNum] = new JLabel();
        bgLabel[bgNum].setBounds(0, 0, 640, 350);

        ImageIcon bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(bgFileName)));
        Image img = bgIcon.getImage(); // get the actual Image
        Image scaledImg = img.getScaledInstance(525, 350, Image.SCALE_SMOOTH); // scale it
        ImageIcon scaledIcon = new ImageIcon(scaledImg); // wrap it back in an ImageIcon


        bgLabel[bgNum].setIcon(scaledIcon);
    }

    public void createClickableObject(int bgNum, int objx, int objy, int objWidth, int objHeight) {
        JButton objectButton = new JButton();
        objectButton.setBounds(objx, objy, objWidth, objHeight);

        // TEMPORARY: Add background color to see positioning
        objectButton.setBackground(Color.RED);

        // Make it look flat: no border, no background fill, no focus painting
        objectButton.setFocusPainted(false);
        objectButton.setBorderPainted(false);
        objectButton.setContentAreaFilled(true); // true for now (to see it)

        // Later you can disable background by setting ContentAreaFilled to false:
        // objectButton.setContentAreaFilled(false);

        objectButton.addActionListener(gm.handler);
        objectButton.setActionCommand("");

        // Add the button to the background panel
        bgPanel[bgNum].add(objectButton);
        bgPanel[bgNum].add(bgLabel[bgNum]); // keep the background label on top

    }

    public void generateScreen() {

        //SCREEN1
        createBackground(1, "scene1_1536x1024.png");
        createClickableObject(1,100, 100, 100, 100);
        createClickableObject(1,300, 100, 100, 100);
        createClickableObject(1,100, 300, 100, 100);

        //SCREEN2
        createBackground(2, "scene2_1536x1024.png");
        createClickableObject(2,100, 100, 100, 100);
        createClickableObject(2,100, 100, 100, 100);
        createClickableObject(2,100, 100, 100, 100);

        //SCREEN3
        createBackground(3, "scene3_1536x1024.png");
        createClickableObject(3,100, 100, 100, 100);
        createClickableObject(3,100, 100, 100, 100);
        createClickableObject(3,100, 100, 100, 100);


    }


}
