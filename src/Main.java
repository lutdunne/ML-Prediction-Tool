import java.util.ArrayList;
import java.util.List;


public class Main {
    static Predictor predictor;

    public static void main(String[] args) {
        FileProcessor file = new FileProcessor("pregnancy_dataset.csv");
        file.connectToFile();

        List<String> fileContents = file.readFile();

//        for (String line : fileContents) {
//            System.out.println(line);
//        }

        predictor = new Predictor();

        predictor.train(fileContents);
//        predictor.printCounts();

        GUI screen = new GUI();
    }

    public static String getPrediction(String age, String stress, String menstrual, String sickness) {
        Female female = new Female(age, stress, menstrual, sickness, "Unknown");
        return predictor.predict(female);
    }
}