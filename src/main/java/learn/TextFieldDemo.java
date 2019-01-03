package learn;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldDemo implements ActionListener {

    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    public TextFieldDemo() {
        JFrame jFrame = new JFrame("Use Text Field");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 120);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");

        jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);
        jbtnRev.addActionListener(this);


        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        jFrame.add(jlabPrompt);
        jFrame.add(jtf);
        jFrame.add(jbtnRev);
        jFrame.add(jlabContents);

        jFrame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Reverse")) {
            jtf.setText(new StringBuffer(jtf.getText()).reverse().toString());
        } else
            jlabContents.setText("You pressed ENTER, Text is " + jtf.getText());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextFieldDemo::new);
    }
}
