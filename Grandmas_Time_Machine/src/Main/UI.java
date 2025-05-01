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
        generateScene();

        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setTitle("Grandma's Time Machine");
        window.setSize(650, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("Welcome to Grandma's Time Machine! Your first task is tho find all the food items in the picture to feed poor little Pepe. Can you spot the fish for a start?");
        messageText.setBounds(50, 410, 525, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 25));
        window.add(messageText);
    }

    public void createBackground(int bgNum, String bgFileName) {

        bgPanel[bgNum] = new JPanel();
        bgPanel[bgNum].setBounds(40, 50, 525, 350);
        //bgPanel[bgNum].setBackground(Color.blue);
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

    public void createClickableObject(int bgNum, int objx, int objy, int objWidth, int objHeight, String actionCommand) {
        JButton objectButton = new JButton();
        objectButton.setBounds(objx, objy, objWidth, objHeight);

        // TEMPORARY: Add background color to see positioning
        objectButton.setBackground(Color.RED);

        // Make it look flat: no border, no background fill, no focus painting
        objectButton.setFocusPainted(false);
        objectButton.setBorderPainted(false);
        objectButton.setContentAreaFilled(true); // true for now (to see it)

        // Later you can disable background by setting ContentAreaFilled to false:
        objectButton.setContentAreaFilled(false);

        objectButton.addActionListener(gm.handler);
        objectButton.setActionCommand(actionCommand);

        // Add the button to the background panel
        bgPanel[bgNum].add(objectButton);
        //bgPanel[bgNum].add(bgLabel[bgNum]); // keep the background label on top

    }

    public void createArrowButton(int bgNum, int objx, int objy, int objWidth, int objHeight, String arrowFileName, String actionCommand) {

        ImageIcon arrowIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource(arrowFileName)));

        JButton arrowButton = new JButton();
        Color brown = new Color(190, 170, 140); //brown color
        arrowButton.setBounds(objx, objy, objWidth, objHeight);
        arrowButton.setBackground(brown);
        arrowButton.setContentAreaFilled(true);
        arrowButton.setBorderPainted(false);
        arrowButton.setFocusPainted(false);
        arrowButton.setIcon(arrowIcon);
        arrowButton.addActionListener(gm.handler);
        arrowButton.setActionCommand(actionCommand);

        bgPanel[bgNum].add(arrowButton);
    }

    public void generateScene() {

        //Scene1
        createBackground(1, "scene1_1536x1024.png");
        createClickableObject(1,175, 105, 87, 45, "clicked fish");
        createClickableObject(1,180, 270, 70, 40, "clicked cheese");
        createClickableObject(1,75, 285, 75, 50, "clicked chicken");
        createClickableObject(1,400, 300, 50, 40, "clicked strawberry");

        createArrowButton(1,475,150,50,50, "right-arrow.png", "goScene2");
        bgPanel[1].add(bgLabel[1]);


        //Scene2
        createBackground(2, "scene2_1536x1024.png");
        createClickableObject(2,20, 0, 70, 110, "clicked lamp");
        createClickableObject(2,190, 180, 80, 30, "clicked glasses");
        createClickableObject(2,420, 210, 80, 80, "clicked teapot");
        createClickableObject(2,120, 230, 50, 100, "clicked cups");
        createArrowButton(2,0,150,50,50, "left-arrow.png", "goScene1");
        createArrowButton(2,475,150,50,50, "right-arrow.png", "goScene3");
        bgPanel[2].add(bgLabel[2]);

        //Scene3
        createBackground(3, "scene3_1536x1024.png");
        createClickableObject(3,380, 250, 70, 70, "clicked yarn");
        createClickableObject(3,400, 190, 90, 50, "clicked notebook");
        createClickableObject(3,225, 310, 50, 20, "clicked pencil");
        createArrowButton(3,0,150,50,50, "left-arrow.png", "goScene2");
        bgPanel[3].add(bgLabel[3]);


    }


}
