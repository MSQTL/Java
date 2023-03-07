package Windows;

import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel {

    public UserPanel(){

        Box mainBox = Box.createHorizontalBox();
        Box leftBox = Box.createVerticalBox();
        Box field_button = Box.createHorizontalBox();
        Box filterBox = Box.createHorizontalBox();

        JLabel search = new JLabel("Поиск");

        JTextField searchField = new JTextField();
        searchField.setMaximumSize(new Dimension(250, 25));

        JButton searchButton = new JButton("Найти");

        JRadioButton filterAuthor = new JRadioButton("по автору");

        JRadioButton filterName = new JRadioButton("по названию");

        JLabel results = new JLabel("Найденные книги:");

        JTable books = new JTable(5, 3);

        JTextArea book = new JTextArea();
        book.setColumns(50);
        book.setRows(25);
        book.setLineWrap(true);
        book.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(book);

        field_button.add(searchField);
        field_button.add(searchButton);

        filterBox.add(filterAuthor);
        filterBox.add(filterName);

        leftBox.add(Box.createVerticalGlue());
        leftBox.add(search);

        leftBox.add(field_button);
        leftBox.add(filterBox);
        leftBox.add(Box.createVerticalGlue());
        leftBox.add(results);
        leftBox.add(books);

        mainBox.add(Box.createHorizontalStrut(20));
        mainBox.add(leftBox);
        mainBox.add(Box.createHorizontalStrut(20));
        mainBox.add(scrollPane);
        mainBox.add(Box.createHorizontalStrut(20));

        add(mainBox);

        setVisible(true);
    }
}
