import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

class Places1 extends JFrame implements ItemListener {
    static JFrame f;
    static JLabel l, l1, l3, l4;
    static JComboBox cb1, cb2;

    public static void main(String[] args) {
        f = new JFrame("frame");
        Places1 pl = new Places1();

        String s1[] = {"Caloocan", "Makati", "Taguig", "Bulacan", "Cavite"};
        String s2[] = {"male", "female", "others"};

        cb1 = new JComboBox(s1);
        cb2 = new JComboBox(s2);

        cb1.setSelectedIndex(3);
        cb2.setSelectedIndex(0);

        cb1.addItemListener(pl);
        cb2.addItemListener(pl);

        cb1.setEditable(true);

        l  = new JLabel("Select your city ");
        l1 = new JLabel("Bulacan is selected");
        l3 = new JLabel("Select your gender ");
        l4 = new JLabel("Male selected");

        l.setForeground(Color.red);
        l1.setForeground(Color.blue);
        l3.setForeground(Color.red);
        l4.setForeground(Color.blue);

        JPanel p = new JPanel();
        p.add(l);
        p.add(cb1);
        p.add(l1);
        p.add(l3);
        p.add(cb2);
        p.add(l4);
        p.setLayout(new FlowLayout());

        f.add(p);
        f.setSize(400, 400);
        f.show();
    }

    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == cb1) {
            l1.setText(cb1.getSelectedItem() + " selected");
        } else {
            l4.setText(cb2.getSelectedItem() + " selected");
        }
    }
}