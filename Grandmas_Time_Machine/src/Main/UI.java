package Main;

import javax.swing.*;
import java.awt.*;
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
        createBackground();
        window.setVisible(true);
    }

    public void createMainField() {
        window = new JFrame();
        window.setTitle("Grandma's Time Machine");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        messageText = new JTextArea("Welcome to Grandma's Time Machine");
        messageText.setBounds(50, 410, 700, 150);
        messageText.setBackground(Color.black);
        messageText.setForeground(Color.white);
        messageText.setEditable(false);
        messageText.setLineWrap(true);
        messageText.setWrapStyleWord(true);
        messageText.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
        window.add(messageText);
    }

    public void createBackground() {

        bgPanel[1] = new JPanel();
        bgPanel[1].setBounds(50, 50, 700, 350);
        bgPanel[1].setBackground(Color.blue);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);

        bgLabel[1] = new JLabel();
        bgLabel[1].setBounds(0, 0, 700, 350);

        //TO DO: add background images for the 3 scenes
        //TO DO: add icons to use in game
        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("dino_scene1.png")));
        Image scaledImage = originalIcon.getImage().getScaledInstance(700, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        bgLabel[1].setIcon(scaledIcon);
        bgPanel[1].add(bgLabel[1]);


    }
}
