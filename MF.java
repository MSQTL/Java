package Windows;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(){

        setTitle("Авторизация");
        setSize(1000,700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Box verticalBox = Box.createVerticalBox();
        Box horizontalBox = Box.createHorizontalBox();

        AuthorizationPanel ap = new AuthorizationPanel();
        //ap.setSize(300, 300);

        AdminPanel adminPanel = new AdminPanel();

        UserPanel userPanel = new UserPanel();

//        horizontalBox.add(Box.createHorizontalGlue());
//        horizontalBox.add(verticalBox);
//        verticalBox.add(Box.createVerticalGlue());
//        verticalBox.add(ap);
//        verticalBox.add(Box.createVerticalGlue());
//        horizontalBox.add(Box.createHorizontalGlue());

        horizontalBox.add(Box.createHorizontalStrut(20));
        horizontalBox.add(userPanel);
        horizontalBox.add(Box.createHorizontalStrut(20));


        setContentPane(horizontalBox);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}

