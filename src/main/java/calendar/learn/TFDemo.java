package calendar.learn;

import com.sun.xml.internal.ws.util.StringUtils;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.Collectors;

public class TFDemo implements ActionListener {

    JTextField jtf;
    JButton jbtnRev;
    JLabel jlabPrompt, jlabContents;

    public TFDemo() {
        JFrame jFrame = new JFrame("Use Text Field");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(240, 120);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jtf = new JTextField(10);
        jtf.setActionCommand("myTF");

        jbtnRev = new JButton("Reverse");

        jtf.addActionListener(this);

        jlabPrompt = new JLabel("Enter text: ");
        jlabContents = new JLabel("");

        jFrame.add(jlabPrompt);
        jFrame.add(jtf);
        jFrame.add(jbtnRev);
        jFrame.add(jlabContents);

        jFrame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Reverse")) {
            jtf.setText(jtf.getText());
        }
    }
}
