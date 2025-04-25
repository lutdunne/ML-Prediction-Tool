public class Predictor {
    public String predict(Female female) {
        if (female.getAgeGroup().equals("Old") &&
                female.getStressLevel().equals("High") &&
                female.getMenstrualPattern().equals("Missed") &&
                female.getMorningSickness().equals("Mild")) {

            double pYes = 0.48 * 0.52 * 0.27 * 0.11 * 0.09;
            double pNo = 0.52 * 0.52 * 0.31 * 0.13 * 0.09;

            double total = pYes + pNo;
            double finalYesProb = pYes / total;

            return "Chances of Pregnancy: " + Math.round(finalYesProb * 100) + "%";
        } else {
            return "Prediction not available for this combination.";
        }
    }
}
