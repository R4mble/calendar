package learn;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CheckBoxDemo implements ItemListener  {

    JLabel jLabelSelected;
    JLabel jLabelChanged;
    JCheckBox jCheckBoxAlpha;
    JCheckBox jCheckBoxBeta;
    JCheckBox jCheckBoxGamma;

    CheckBoxDemo() {
        JFrame jFrame = new JFrame("Check Box");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(500, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabelSelected = new JLabel();
        jLabelChanged = new JLabel();

        jCheckBoxAlpha = new JCheckBox("Alpha");
        jCheckBoxBeta = new JCheckBox("Beta");
        jCheckBoxGamma = new JCheckBox("Gamma");

        jCheckBoxAlpha.addItemListener(this);
        jCheckBoxBeta.addItemListener(this);
        jCheckBoxGamma.addItemListener(this);

        jFrame.add(jCheckBoxAlpha);
        jFrame.add(jCheckBoxBeta);
        jFrame.add(jCheckBoxGamma);
        jFrame.add(jLabelChanged);
        jFrame.add(jLabelSelected);
        jFrame.setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        String str = "";

        JCheckBox cb = (JCheckBox) e.getItem();
        if (cb.isSelected()) {
            jLabelChanged.setText(cb.getText() + " was just selected.");
        } else {
            jLabelChanged.setText(cb.getText() + " was just cleared.");
        }

        if (jCheckBoxAlpha.isSelected()) {
            str += "Alpha";
        }
        if (jCheckBoxBeta.isSelected()) {
            str += " Beta";
        }
        if (jCheckBoxGamma.isSelected()) {
            str += " Gamma";
        }

        jLabelSelected.setText("Selected check boxes: " + str);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CheckBoxDemo::new);
    }
}
