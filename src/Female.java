public class Female {
    private String ageGroup;
    private String stressLevel;
    private String menstrualPattern;
    private String morningSickness;
    private String pregnant;

    public String getAgeGroup() {
        return ageGroup;
    }

    public String getMorningSickness() {
        return morningSickness;
    }

    public String getStressLevel() {
        return stressLevel;
    }

    public String getMenstrualPattern() {
        return menstrualPattern;
    }

    public String getPregnant() {
        return pregnant;
    }


    public Female(String ageGroup, String stressLevel, String menstrualPattern, String morningSickness, String pregnant) {
        this.ageGroup = ageGroup;
        this.stressLevel = stressLevel;
        this.menstrualPattern = menstrualPattern;
        this.morningSickness = morningSickness;
        this.pregnant = pregnant;
    }
}
