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
        createObject();

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
        bgPanel[1].setBounds(70, 50, 700, 350);
        bgPanel[1].setBackground(Color.blue);
        bgPanel[1].setLayout(null);
        window.add(bgPanel[1]);


        bgLabel[1] = new JLabel();
        bgLabel[1].setBounds(0, 0, 700, 350);

        ImageIcon bgIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("scene1_1536x1024.png")));
        bgLabel[1].setIcon(bgIcon);
    }

    public void createObject() {
        JLabel objectLabel = new JLabel();
        objectLabel.setBounds(400, 150, 193, 163);

        ImageIcon objectIcon = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("cheese_193x163.png")));
        objectLabel.setIcon(objectIcon);

        bgPanel[1].add(objectLabel);
        bgPanel[1].add(bgLabel[1]);
    }
}
