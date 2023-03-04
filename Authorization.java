package Windows;

import javax.swing.*;
import java.awt.*;

public class Authorization extends JFrame {
    public Authorization(){

        setTitle("Авторизация");
        setSize(1000,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        Dimension fieldSize = new Dimension(100, 20);
        Font text = new Font("Century Gothic", Font.PLAIN, 20);

        JPanel panel = new JPanel();
        //panel.setPreferredSize(new Dimension(400, 400));
        panel.setBackground(Color.CYAN);
        add(panel);

        JLabel loginLabel = new JLabel("Введите Ваш логин: ");
        loginLabel.setFont(text);

        JTextField loginField = new JTextField();
        loginField.setPreferredSize(fieldSize);

        JLabel passwordLabel = new JLabel("Введите Ваш пароль: ");
        passwordLabel.setFont(text);

        JTextField passwordField = new JTextField();
        passwordField.setPreferredSize(fieldSize);

        JButton welcomeButton = new JButton("Войти");
        welcomeButton.setBackground(Color.PINK);


        panel.add(loginLabel);
        panel.add(loginField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(welcomeButton);

        setVisible(true);
    }
}
