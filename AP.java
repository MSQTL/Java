package Windows;

import sample.Connection2MySQL;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Objects;

public class AuthorizationPanel extends JPanel {

    String url = "jdbc:mysql://localhost:3306/e_library";
    String user = "root";
    String password = "1234";
    Connection connection;
    Statement stmt;
    ResultSet rs;
    String query;
    public AuthorizationPanel(){

        setLayout(null);

        Dimension panelSize = new Dimension(190, 70);
        setPreferredSize(panelSize);
        Dimension fieldSize = new Dimension(100, 20);
        Font text = new Font("Century Gothic", Font.PLAIN, 20);
        Font button = new Font("Century Gothic", Font.ITALIC, 18);
        Font head = new Font("Century Gothic",Font.PLAIN, 25);

        JLabel header = new JLabel("<html><u>Вход в систему</u></html>");
        header.setBounds(110, 30, 200, 25);
        header.setFont(head);

        JLabel loginLabel = new JLabel("Введите Ваш логин: ");
        loginLabel.setBounds(10, 100, 230, 25);
        loginLabel.setFont(text);

        JTextField loginField = new JTextField();
        loginField.setBounds(260, 100, 165, 30);
        loginField.setPreferredSize(fieldSize);

        JLabel passwordLabel = new JLabel("Введите Ваш пароль: ");
        passwordLabel.setBounds(10, 165, 230, 25);
        passwordLabel.setFont(text);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setEchoChar('*');
        passwordField.setBounds(260, 165, 165, 30);
        //passwordField.setFont();
        passwordField.setPreferredSize(fieldSize);

        JButton welcomeButton = new JButton("Войти");
        welcomeButton.setBounds(260, 220,165, 25);
        welcomeButton.setHorizontalTextPosition(JButton.CENTER);
        welcomeButton.setVerticalTextPosition(JButton.CENTER);
        welcomeButton.setFont(button);
        Color color = new Color(37, 114, 247);
        welcomeButton.setBackground(color);
        welcomeButton.setForeground(Color.white);

        welcomeButton.addActionListener(e -> {
            try {
                StringBuilder up;
                char[] m = (passwordField.getPassword());
                for(int i = 0; i < (Arrays.toString(passwordField.getPassword())).length(); i++){

                }
                connection = DriverManager.getConnection(url, user, password);
                stmt = connection.createStatement();
                query = "select * from users";
                rs = stmt.executeQuery(query);
                while (rs.next()){

                    String login = rs.getString("user_login");
                    String password = rs.getString("user_password");
                    System.out.println(Arrays.toString(passwordField.getPassword()));
                    if(Objects.equals(login, loginField.getText()) && Objects.equals(password, )){
                        setVisible(false);
                        System.out.println("!!!!");
                    }
                }
            }
            catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            finally {
                try { connection.close(); } catch (SQLException se) { se.printStackTrace(); }
                try { stmt.close(); } catch (SQLException se) { se.printStackTrace(); }
                try { rs.close(); } catch (SQLException se) { se.printStackTrace(); }

            }

        });

        add(header);
        add(loginLabel);
        add(loginField);
        add(passwordLabel);
        add(passwordField);
        add(welcomeButton);

        setVisible(true);
    }

}
