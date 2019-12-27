package lesson8;

import javax.swing.*;

public class Lesson8 {

    public static void main(String[] args) {
     FormMain formMain=new FormMain();
        JFrame.setDefaultLookAndFeelDecorated(true);
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(formMain);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
}
