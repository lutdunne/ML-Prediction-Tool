import java.util.ArrayList;
import java.util.List;


public class Main {
    static Predictor predictor;

    // Load data, train model and launch the GUI
    public static void main(String[] args) {
        FileProcessor file = new FileProcessor("pregnancy_dataset.csv");
        file.connectToFile();

        List<Female> fullDataset = file.loadFemaleData();
        predictor = new Predictor();
        Trainer.trainAndTest(predictor, fullDataset);

        GUI screen = new GUI();
    }

    // Predict pregnacy outcome
    public static ArrayList<Integer> getPrediction(String age, String stress, String menstrual, String sickness) {
        Female female = new Female(age, stress, menstrual, sickness, "Unknown");
        return predictor.predict(female);
    }

    // Add new example
    public static void saveNewExample(String age, String stress, String menstrual, String sickness, String pregnant) {
        Female female = new Female(age, stress, menstrual, sickness, pregnant);
        predictor.updateWithNewExample(female);
        System.out.println("New example added successfully");
    }
}