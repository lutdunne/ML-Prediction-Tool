import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Class handles training and prediction using Naive Bayes approach
public class Predictor {
    int totalYes = 0;
    int totalNo = 0;

    // Frequency maps for each feature
    Map<String, Integer> feature1YesCounts = new HashMap<>();
    Map<String, Integer> feature1NoCounts = new HashMap<>();
    Map<String, Integer> feature2YesCounts = new HashMap<>();
    Map<String, Integer> feature2NoCounts = new HashMap<>();
    Map<String, Integer> feature3YesCounts = new HashMap<>();
    Map<String, Integer> feature3NoCounts = new HashMap<>();
    Map<String, Integer> feature4YesCounts = new HashMap<>();
    Map<String, Integer> feature4NoCounts = new HashMap<>();

    // Train the model with a list of female objects
    public void train(List<Female> females) {
        totalYes = 0;
        totalNo = 0;

        for(Female female : females) {
            String ageGroup = female.getAgeGroup();
            String stressLevel = female.getStressLevel();
            String menstrualPattern = female.getMenstrualPattern();
            String morningSickness = female.getMorningSickness();
            String pregnant = female.getPregnant();

            // Count frequencies for each feature value based on pregnancy label
            if (pregnant.equals("Yes")) {
                totalYes++;
                feature1YesCounts.put(ageGroup, feature1YesCounts.getOrDefault(ageGroup, 0) + 1);
                feature2YesCounts.put(stressLevel, feature2YesCounts.getOrDefault(stressLevel, 0) + 1);
                feature3YesCounts.put(menstrualPattern, feature3YesCounts.getOrDefault(menstrualPattern, 0) + 1);
                feature4YesCounts.put(morningSickness, feature4YesCounts.getOrDefault(morningSickness, 0) + 1);
            } else if (pregnant.equals("No")) {
                totalNo++;
                feature1NoCounts.put(ageGroup, feature1NoCounts.getOrDefault(ageGroup, 0) + 1);
                feature2NoCounts.put(stressLevel, feature2NoCounts.getOrDefault(stressLevel, 0) + 1);
                feature3NoCounts.put(menstrualPattern, feature3NoCounts.getOrDefault(menstrualPattern, 0) + 1);
                feature4NoCounts.put(morningSickness, feature4NoCounts.getOrDefault(morningSickness, 0) + 1);
            }
        }
    }

    // Predict if a female is pregnant based off of the train data
    public ArrayList<Integer> predict(Female female) {
        ArrayList<Integer> result = new ArrayList<>();
        double pYes = 1.0;
        double pNo = 1.0;

        // Multiply probabilities for each feature
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


        if(pYes > pNo) {
            result.add(1);
        } else {
            result.add(0);
        }
        // Add probability score of the predicted outcome
        result.add((int)(Math.round(finalYesProb * 100)));

        return result;

    }

    // Calculate probability for a given feature value
    public double getProbability(Map<String, Integer> featureCounts, String featureValue, int totalCount) {
        int featureCount = featureCounts.getOrDefault(featureValue, 0);
        return featureCount / (double) totalCount;
    }

    // Update model counts with new example
    public void updateWithNewExample(Female female) {
        String ageGroup = female.getAgeGroup();
        String stressLevel = female.getStressLevel();
        String menstrualPattern = female.getMenstrualPattern();
        String morningSickness = female.getMorningSickness();
        String pregnant = female.getPregnant();

        if(pregnant.equals("Yes")) {
            totalYes++;
            feature1YesCounts.put(ageGroup, feature1YesCounts.getOrDefault(ageGroup, 0) + 1);
            feature2YesCounts.put(stressLevel, feature2YesCounts.getOrDefault(stressLevel, 0) + 1);
            feature3YesCounts.put(menstrualPattern, feature3YesCounts.getOrDefault(menstrualPattern, 0) + 1);
            feature4YesCounts.put(morningSickness, feature4YesCounts.getOrDefault(morningSickness, 0) + 1);
        } else if(pregnant.equals("No")) {
            totalNo++;
            feature1NoCounts.put(ageGroup, feature1NoCounts.getOrDefault(ageGroup, 0) + 1);
            feature2NoCounts.put(stressLevel, feature2NoCounts.getOrDefault(stressLevel, 0) + 1);
            feature3NoCounts.put(menstrualPattern, feature3NoCounts.getOrDefault(menstrualPattern, 0) + 1);
            feature4NoCounts.put(morningSickness, feature4NoCounts.getOrDefault(morningSickness, 0) + 1);
        }
        System.out.println("Updating with new example...");
        System.out.println("Total Yes: " + totalYes);
        System.out.println("Total No: " + totalNo);
    }
}
