package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame(); // FlowLayout - Default  -->  לסדר אלמנטים בשורה

        frame.setSize(400, 400);

        frame.setLayout(new GridLayout(2, 3));


//        JButton btn1 = new JButton("1");
//        JButton btn2 = new JButton("2");
//        JButton btn3 = new JButton("3");
//        JButton btn4 = new JButton("4");
//        JButton btn5 = new JButton("5");
//        JButton btn6 = new JButton("6");
//        frame.add(btn1);
//        frame.add(btn2);
//        frame.add(btn3);
//        frame.add(btn4);
//        frame.add(btn5);
//        frame.add(btn6);

        // int array[] = new int[10];
        JButton buttons[] = new JButton[6];
        for (int i = 0; i < buttons.length ; i++) {
            buttons[i] = new JButton("Button " + (i+1));

            buttons[i]
                    .addActionListener(
                            new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    System.out.println("CLICK");
                                    System.out.println(e);
                                }
                            }
                    );

            frame.add(buttons[i]);
        }

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}