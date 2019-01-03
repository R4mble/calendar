package learn;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class ListDemo implements ListSelectionListener {

    JList<String> jList;
    JLabel jLabel;
    JScrollPane jScrollPane;
    String[] names = {"Java", "C", "C++", "Python", "Go", "Scala", "Clojure", "Groovy", "PHP", "Swift", "Lua",
            "C#", "Scheme", "JavaScript", "Ruby", "Assembly", "Perl", "HTML", "CSS", "Erlang", "Haskell", "Object-C",
            "SQL", "Shell", "TypeScript", "VB"};

    ListDemo() {
        JFrame jFrame = new JFrame("JList Demo");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(200, 100);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jList = new JList<>(names);
        jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        jScrollPane = new JScrollPane(jList);
        jScrollPane.setPreferredSize(new Dimension(120, 90));
        jLabel = new JLabel("Please choose a language");

        jList.addListSelectionListener(this);

        jFrame.add(jScrollPane);
        jFrame.add(jLabel);

        jFrame.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int idx = jList.getSelectedIndex();

        if (idx != -1) {
            jLabel.setText("Current selection: " + names[idx]);
        } else {
            jLabel.setText("Please choose a name");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ListDemo::new);
    }
}
