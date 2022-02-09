package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeGame extends JFrame
        implements ActionListener {

    // שדות המחלקה:
    // חלון כללי
    private JFrame frame;
    // נחלק את המסך
    private JPanel textPanel = new JPanel();
    private JPanel gamePanel = new JPanel();

    // הטקסט שמוצג בפאנל העליון
    private JLabel textLabel = new JLabel();


    public TicTacToeGame() {
        frame = new JFrame("TicTacToe");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(textPanel);

        textLabel.setText("Let's Play TicTacToe!");
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
        textPanel.add(textLabel);



//        frame.getContentPane()
//                .setBackground(Color.RED);

        frame.add(gamePanel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}