package learn;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonDemo implements ActionListener {
    JLabel jLabel;

    ButtonDemo() {
        JFrame jFrame = new JFrame("Simple Swing");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(400, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton jButtonUp = new JButton("Up");
        JButton jButtonDown = new JButton("Down");

//        jButtonUp.addActionListener(e -> System.out.println(e.getActionCommand()));
        jButtonUp.addActionListener(this);

        jButtonDown.addActionListener(e -> System.out.println(e.getSource()));
        jButtonDown.addActionListener(this);

        jFrame.add(jButtonUp);
        jFrame.add(jButtonDown);

        jLabel = new JLabel("A Label");
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
        if (event.getActionCommand().equals("Up")) {
            jLabel.setText("You pressed up");
        } else {
            jLabel.setText("U pressed down");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonDemo::new);
    }
}
