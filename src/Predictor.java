import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Predictor {
    int totalYes = 0;
    int totalNo = 0;

    Map<String, Integer> feature1YesCounts = new HashMap<>();
    Map<String, Integer> feature1NoCounts = new HashMap<>();
    Map<String, Integer> feature2YesCounts = new HashMap<>();
    Map<String, Integer> feature2NoCounts = new HashMap<>();
    Map<String, Integer> feature3YesCounts = new HashMap<>();
    Map<String, Integer> feature3NoCounts = new HashMap<>();
    Map<String, Integer> feature4YesCounts = new HashMap<>();
    Map<String, Integer> feature4NoCounts = new HashMap<>();

    // Method to count the yes's and no's of each feature
    public void train(List<String> lines) {
        for(String line : lines) {
            String[] values = line.split(",");

            String feature1 = values[0];
            String feature2 = values[1];
            String feature3 = values[2];
            String feature4 = values[3];
            String label = values[4];

            if(label.equals("Yes")) {
                totalYes++;
                feature1YesCounts.put(feature1, feature1YesCounts.getOrDefault(feature1, 0) + 1);
                feature2YesCounts.put(feature2, feature2YesCounts.getOrDefault(feature2, 0) + 1);
                feature3YesCounts.put(feature3, feature3YesCounts.getOrDefault(feature3, 0) + 1);
                feature4YesCounts.put(feature4, feature4YesCounts.getOrDefault(feature4, 0) + 1);
            } else if(label.equals("No")) {
                totalNo++;
                feature1NoCounts.put(feature1, feature1NoCounts.getOrDefault(feature1, 0) + 1);
                feature2NoCounts.put(feature2, feature2NoCounts.getOrDefault(feature2, 0) + 1);
                feature3NoCounts.put(feature3, feature3NoCounts.getOrDefault(feature3, 0) + 1);
                feature4NoCounts.put(feature4, feature4NoCounts.getOrDefault(feature4, 0) + 1);
            }
        }
//        System.out.println("Total Yes: " + totalYes);
//        System.out.println("Total No: " + totalNo);
    }

    public void printCounts() {
//        System.out.println("=== Feature 1 (AgeGroup) Counts ===");
//        System.out.println("Yes Counts: " + feature1YesCounts);
//        System.out.println("No Counts: " + feature1NoCounts);
//
//        System.out.println("\n=== Feature 2 (StressLevel) Counts ===");
//        System.out.println("Yes Counts: " + feature2YesCounts);
//        System.out.println("No Counts: " + feature2NoCounts);
//
//        System.out.println("\n=== Feature 3 (MenstrualPattern) Counts ===");
//        System.out.println("Yes Counts: " + feature3YesCounts);
//        System.out.println("No Counts: " + feature3NoCounts);
//
//        System.out.println("\n=== Feature 4 (MorningSickness) Counts ===");
//        System.out.println("Yes Counts: " + feature4YesCounts);
//        System.out.println("No Counts: " + feature4NoCounts);

        System.out.println("\n=== Totals ===");
        System.out.println("Total Yes: " + totalYes);
        System.out.println("Total No: " + totalNo);
    }

//     Method to predict if a female is pregnant based off of the train data
    public String predict(Female female) {
        double pYes = 1.0;
        double pNo = 1.0;

        pYes *= getProbability(feature1YesCounts, female.getAgeGroup(), totalYes);
        pNo *= getProbability(feature1NoCounts, female.getAgeGroup(), totalNo);

        pYes *= getProbability(feature2YesCounts, female.getStressLevel(), totalYes);
        pNo *= getProbability(feature2NoCounts, female.getStressLevel(), totalNo);

        pYes *= getProbability(feature3YesCounts, female.getMenstrualPattern(), totalYes);
        pNo *= getProbability(feature3NoCounts, female.getMenstrualPattern(), totalNo);

        pYes *= getProbability(feature4YesCounts, female.getMorningSickness(), totalYes);
        pNo *= getProbability(feature4NoCounts, female.getMorningSickness(), totalNo);

        double total = pYes + pNo;
        double finalYesProb = pYes / total;

        return "Chances of Pregnancy: " + Math.round(finalYesProb * 100) + "%";

    }

    public double getProbability(Map<String, Integer> featureCounts, String featureValue, int totalCount) {
        int featureCount = featureCounts.getOrDefault(featureValue, 0);
        double probability = featureCount / (double) totalCount;

        System.out.println("Feature: " + featureValue + ", Probability: " + probability);
        return probability;
    }


}
