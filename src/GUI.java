import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JPanel panel1;
    JButton predict, save;
    JComboBox ageGroupBox, stressLevelBox, menstrualBox, sicknessBox, pregnantBox;
    JLabel ageGroup, stressLevel, menstrualPattern, morningSicknessLevel, resultLabel;

    public GUI() {
        panel1 = new JPanel();

        String[] ageGroups = {"Young", "Old"};
        String[] stressLevels = {"High", "Low"};
        String[] menstrualPatterns = {"Regular", "Missed"};
        String[] morningSicknessLevels = {"Mild", "Severe"};
        String[] pregnantOptions = {"Yes", "No"};


        ageGroup = new JLabel("Age Group");
        stressLevel = new JLabel("Stress Level");
        menstrualPattern = new JLabel("Menstrual Pattern");
        morningSicknessLevel = new JLabel("Morning Sickness Level");

        ageGroupBox = new JComboBox<>(ageGroups);
        stressLevelBox = new JComboBox<>(stressLevels);
        menstrualBox = new JComboBox<>(menstrualPatterns);
        sicknessBox = new JComboBox<>(morningSicknessLevels);
        pregnantBox = new JComboBox<>(pregnantOptions);

        save = new JButton("Save");

        predict = new JButton("Predict");

        resultLabel = new JLabel("Prediction will appear here");
        // sets GUI size
        setSize(500, 500);

        predict.addActionListener(this);
        save.addActionListener(this);
//        delete.addActionListener(this);


        panel1.add(ageGroup);
        panel1.add(ageGroupBox);

        panel1.add(stressLevel);
        panel1.add(stressLevelBox);

        panel1.add(menstrualPattern);
        panel1.add(menstrualBox);

        panel1.add(morningSicknessLevel);
        panel1.add(sicknessBox);

        panel1.add(save);

        panel1.add(predict);
        panel1.add(resultLabel);

        panel1.add(pregnantBox);

        add(panel1);

        setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == predict) {
            String age = (String) ageGroupBox.getSelectedItem();
            String stress = (String) stressLevelBox.getSelectedItem();
            String menstrual = (String) menstrualBox.getSelectedItem();
            String sickness = (String) sicknessBox.getSelectedItem();

            String prediction = Main.getPrediction(age, stress, menstrual, sickness);


            resultLabel.setText(prediction);
        }

        if (e.getSource() == save) {
            String age = (String) ageGroupBox.getSelectedItem();
            String stress = (String) stressLevelBox.getSelectedItem();
            String menstrual = (String) menstrualBox.getSelectedItem();
            String sickness = (String) sicknessBox.getSelectedItem();
            String pregnant = (String) pregnantBox.getSelectedItem();

            Main.saveNewExample(age, stress, menstrual, sickness, pregnant);

            JOptionPane.showMessageDialog(null, "New example saved!");
        }
    }
}


