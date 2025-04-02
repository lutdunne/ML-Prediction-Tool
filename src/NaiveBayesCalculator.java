import java.util.HashMap;
import java.util.Map;

public class NaiveBayesCalculator {
    private final String[] features = {"Young", "Old", "High Stress", "Low Stress", "Healthy Diet", "Unhealthy Diet", "Active", "Inactive"};
    private int totalPregnant;
    private int totalNotPregnant;
    Map<String, Integer> isPregnantFeatureToCount = new HashMap<String, Integer>();
    Map<String, Integer> isNotPregnantFeatureToCount = new HashMap<String, Integer>();

    public NaiveBayesCalculator(Map<String, Integer> isPregnantFeatureToCount, Map<String, Integer> isNotPregnantFeatureToCount, int totalPregnant, int totalNotPregnant) {
        this.isPregnantFeatureToCount = isPregnantFeatureToCount;
        this.isNotPregnantFeatureToCount = isNotPregnantFeatureToCount;
        this.totalPregnant = totalPregnant;
        this.totalNotPregnant = totalNotPregnant;
    }

    public double calculateProbabilities() {
        double probability = 1.0;

        for(String feature : features) {
//            System.out.println("Feature: " + feature);
            int pregnantCount = isPregnantFeatureToCount.get(feature);
            System.out.print(pregnantCount + ", ");
            double featureProbabilityPregnant = (totalPregnant > 0) ? (double) pregnantCount / totalPregnant : 0;
            probability *= featureProbabilityPregnant;

        }

        return probability;
    }
}
