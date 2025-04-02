import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        Female female1 = new Female(true, true, true, false, true);
        Female female2 = new Female(true, false, true, true, true);
        Female female3 = new Female(true, false, false, false, false);
        Female female4 = new Female(true, true, true, true, false);
        Female female5 = new Female(false, false, false, false, false);

        ArrayList<Female> females = new ArrayList<Female>();
        females.add(female1);
        females.add(female2);
        females.add(female3);
        females.add(female4);
        females.add(female5);

//        Map<String, Integer> pregnantOrNotToFemaleAttributeCounts = new HashMap<String, Integer>();
//        int isPregnantAndIsStressedCounter;



        Classifier classifier = new Classifier();
        classifier.countFeaturesFromFemales(females);
        classifier.printFeatureTable();
//        System.out.println(classifier.isPregnantFeatureToCount.get("Young"));

    }
}