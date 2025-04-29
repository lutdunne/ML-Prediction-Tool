import java.util.ArrayList;
import java.util.List;

// Class to handle training and testing
public class Trainer {

    // Split dataset, train and print test accuracy
    public static void trainAndTest(Predictor predictor, List<Female> dataset) {
        List<Female> yesExamples = new ArrayList<>();
        List<Female> noExamples = new ArrayList<>();

        // Seperate examples based on label
        for (Female example : dataset) {
            if (example.getPregnant().equals("Yes")) {
                yesExamples.add(example);
            } else {
                noExamples.add(example);
            }
        }

        List<Female> trainingData = new ArrayList<>();
        List<Female> testData = new ArrayList<>();

        // 75% of each class for training, 25% for testing
        int yesTrainingCutOff = (int) (yesExamples.size() * 0.75);
        int noTrainingCutOff = (int) (noExamples.size() * 0.75);

        // Add Yes examples to train/test sets
        for (int i = 0; i < yesExamples.size(); i++) {
            if (i < yesTrainingCutOff) {
                trainingData.add(yesExamples.get(i));
            } else {
                testData.add(yesExamples.get(i));
            }
        }

        // Add No examples to train/test sets
        for (int i = 0; i < noExamples.size(); i++) {
            if (i < noTrainingCutOff) {
                trainingData.add(noExamples.get(i));
            } else {
                testData.add(noExamples.get(i));
            }
        }

        // Print sizes
        System.out.println("Training set size: " + trainingData.size());
        System.out.println("Testing set size: " + testData.size());

        // Train predictor
        predictor.train(trainingData);

        // Check how many predictions are correct
        int correct = 0;
        for (Female female : testData) {
            ArrayList<Integer> predict = predictor.predict(female);

            if ((female.getPregnant().equals("Yes") && predict.get(0) == 1) ||
                    (female.getPregnant().equals("No") && predict.get(0) == 0)) {
                correct++;
            }
        }

        // Calculate test accuracy
        double testAccuracy = Math.round(((float) correct / testData.size()) * 100);
        System.out.println("Accuracy: " + testAccuracy + "%");
    }
}
