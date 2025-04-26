import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {
    JPanel panel1;
    JButton predict;
    JComboBox ageGroupBox, stressLevelBox, menstrualBox, sicknessBox;
    JLabel ageGroup, stressLevel, menstrualPattern, morningSicknessLevel, resultLabel;

    public GUI() {
        panel1 = new JPanel();

        String[] ageGroups = {"Young", "Old"};
        String[] stressLevels = {"High", "Low"};
        String[] menstrualPatterns = {"Regular", "Missed"};
        String[] morningSicknessLevels = {"Mild", "Severe"};

        ageGroup = new JLabel("Age Group");
        stressLevel = new JLabel("Stress Level");
        menstrualPattern = new JLabel("Menstrual Pattern");
        morningSicknessLevel = new JLabel("Morning Sickness Level");

        ageGroupBox = new JComboBox<>(ageGroups);
        stressLevelBox = new JComboBox<>(stressLevels);
        menstrualBox = new JComboBox<>(menstrualPatterns);
        sicknessBox = new JComboBox<>(morningSicknessLevels);


        predict = new JButton("Predict");

        resultLabel = new JLabel("Prediction will appear here");
        // sets GUI size
        setSize(500, 500);

        predict.addActionListener(this);
//        showall.addActionListener(this);
//        delete.addActionListener(this);


        panel1.add(ageGroup);
        panel1.add(ageGroupBox);

        panel1.add(stressLevel);
        panel1.add(stressLevelBox);

        panel1.add(menstrualPattern);
        panel1.add(menstrualBox);

        panel1.add(morningSicknessLevel);
        panel1.add(sicknessBox);

        panel1.add(predict);
        panel1.add(resultLabel);

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

            Female female = new Female(age, stress, menstrual, sickness);
            Predictor predictor = new Predictor();
            String prediction = predictor.predict(female);

            resultLabel.setText(prediction);
        }
    }
}


