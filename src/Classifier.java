import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Classifier {
    private final String[] features = {"Young", "Old", "High Stress", "Low Stress", "Healthy Diet", "Unhealthy Diet", "Active", "Inactive"};
    private int totalPregnant = 0;
    private int totalNotPregnant = 0;
    Map<String, Integer> isPregnantFeatureToCount = new HashMap<String, Integer>();
    Map<String, Integer> isNotPregnantFeatureToCount = new HashMap<String, Integer>();
//    Map<String, Integer> featureToCount = new HashMap<String, Integer>();


    public Classifier() {
        for(String feature : features) {
            isPregnantFeatureToCount.putIfAbsent(feature, 0);
            isNotPregnantFeatureToCount.putIfAbsent(feature, 0);
//            featureToCount.putIfAbsent(feature, 0);
        }
    }

    public int getTotalPregnant() {
        return totalPregnant;
    }

    public int getTotalNotPregnant() {
        return totalNotPregnant;
    }

    public void countFeaturesFromFemales(ArrayList<Female> females) {
        for(Female female : females) {
            boolean isPregnant = female.isPregnant();

            String ageGroup = female.isAgeIsYoung() ? "Young" : "Old";
            String stressLevel = female.isStressLevelLow() ? "Low Stress" : "High Stress";
            String dietType = female.isUnhealthy() ? "Healthy Diet" : "Unhealthy Diet";
            String exerciseLevel = female.isInactive() ? "Active" : "Inactive";


            if (isPregnant) {
                isPregnantFeatureToCount.put(ageGroup, isPregnantFeatureToCount.get(ageGroup) + 1);
                isPregnantFeatureToCount.put(stressLevel, isPregnantFeatureToCount.get(stressLevel) + 1);
                isPregnantFeatureToCount.put(dietType, isPregnantFeatureToCount.get(dietType) + 1);
                isPregnantFeatureToCount.put(exerciseLevel, isPregnantFeatureToCount.get(exerciseLevel) + 1);
            } else {
                isNotPregnantFeatureToCount.put(ageGroup, isNotPregnantFeatureToCount.get(ageGroup) + 1);
                isNotPregnantFeatureToCount.put(stressLevel, isNotPregnantFeatureToCount.get(stressLevel) + 1);
                isNotPregnantFeatureToCount.put(dietType, isNotPregnantFeatureToCount.get(dietType) + 1);
                isNotPregnantFeatureToCount.put(exerciseLevel, isNotPregnantFeatureToCount.get(exerciseLevel) + 1);
            }


        }



        for (Female female : females) {
            if (female.isPregnant()) {
                totalPregnant++;  // Count total pregnant people
            } else {
                totalNotPregnant++; // Count total non-pregnant people
            }
        }
    }
    public void  printFeatureTable() {
        System.out.println("| Type         | Young        | Old          | Healthy      | Unhealthy    | Active       | Inactive     | Stress High  | Stress Low   |");
        System.out.println("|--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------|--------------|");
        System.out.print("| IsPregnant   | ");
        System.out.print("------");
        for (String feature : features) {
//
            int count = isPregnantFeatureToCount.getOrDefault(feature, 0);
            System.out.print(count +  "----- | ------");
        }
        System.out.println(); // End of "Is Pregnant" row

        // Print "Is Not Pregnant" row
        System.out.print("| IsNotPregnant| ");
        System.out.print("------");
        for (String feature : features) {
            // Get count for the feature, default to 0 if not present
            int count = isNotPregnantFeatureToCount.getOrDefault(feature, 0);
            System.out.print(count + "----- | ------");
        }
        System.out.println(); // End of "Is Not Pregnant" row

        // Print "Total" row
        System.out.print("| Total        | ");
        System.out.print("------");
        for (String feature : features) {
            int count = isPregnantFeatureToCount.getOrDefault(feature, 0) + isNotPregnantFeatureToCount.getOrDefault(feature, 0);
            System.out.print(count +  "----- | ------");
        }
        System.out.println();
        System.out.println("Total Pregnant: " + totalPregnant);
        System.out.println("Total Not Pregnant: " + totalNotPregnant);
    }
}
