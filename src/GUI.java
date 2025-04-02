import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    JPanel panel1;


    public GUI() {
        panel1 = new JPanel();

        // sets GUI size
        setSize(500, 500);

//        save.addActionListener(this);
//        showall.addActionListener(this);
//        delete.addActionListener(this);

        add(panel1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == save) {
//            if (name.getText().equals("") || surname.getText().equals("") || city.getText().equals("")) {
//                JOptionPane.showMessageDialog(this,"Please fill out all fields");
//            } else {
//                Person person = new Person(name.getText(), surname.getText(), city.getText());
//                JOptionPane.showMessageDialog(this, person.toString());
//                guiList.add(person);
//
//                name.setText("");
//                surname.setText("");
//                city.setText("");
//            }
//        } else if (e.getSource() == showall) {
//            StringBuilder allPersons = new StringBuilder("Saved Persons:\n");
//            for (Person person : guiList) {
//                allPersons.append(person).append("\n");
//            }
//            JOptionPane.showMessageDialog(this, allPersons.toString());
//
//        } else if (e.getSource() == delete) {
//            guiList.clear();
//        }
//    }
}
