package git.kentfarr.scraprr;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class menu {

    public menu() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();


        JFrame frame = new JFrame("Scraprr");
        // finds the size of the frame then dives it by 10 to center it
        int x = (int) ((width / 10) - (frame.getWidth() / 10));
        int y = (int) ((height / 10) - (frame.getHeight() / 10));


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize((int) width / 4, (int) height / 4);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Welcome to Scraprr - Enter Username and Urls");
        JLabel label2 = new JLabel("results will be written to output.txt");
        JLabel label3 = new JLabel("Enter Urls seperated by commas");
        JTextField textField1 = new JTextField("Enter Target");
        textField1.setPreferredSize(new Dimension(x, y));
        JTextField textField2 = new JTextField("Enter Urls");
        textField2.setPreferredSize(new Dimension(x, y));


        JButton socialb1 = new JButton("Social Search");
        socialb1.addActionListener(e -> {
            String username = textField1.getText();
            new socialSearch(username);
        });

        JButton urlb1 = new JButton("Url Search");
        urlb1.addActionListener(e -> {
            String target = textField1.getText();
            ArrayList<String> urls = new ArrayList<String>();
            for (String url : textField2.getText().split(",")) {
                urls.add(url);
            }

            try {
                new htmlContentSearch(target, urls);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        JButton outputb1 = new JButton("Output File");
        outputb1.addActionListener(e -> {
            try {
                Runtime.getRuntime().exec("notepad.exe src/main/output/output.txt");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });




        urlb1.addActionListener(e -> {
            String target = textField1.getText();
            ArrayList<String> urls = new ArrayList<String>();
            urls.add(textField2.getText());
            try {
                new htmlContentSearch(target, urls);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });


        frame.getContentPane().add(label1);
        frame.getContentPane().add(label2);
        frame.getContentPane().add(label3);
        frame.getContentPane().add(socialb1);
        frame.getContentPane().add(urlb1);
        frame.getContentPane().add(outputb1);
        frame.getContentPane().add(textField1);
        frame.getContentPane().add(textField2);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
