public class Female {
    private boolean ageIsYoung;
    private boolean stressLevelLow;
    private boolean isUnhealthy;
    private boolean isInactive;
    private boolean isPregnant; //optional?

    public Female(boolean ageIsYoung, boolean stressLevelLow, boolean isUnhealthy, boolean isInactive, boolean isPregnant) {
        this.ageIsYoung = ageIsYoung;
        this.stressLevelLow = stressLevelLow;
        this.isUnhealthy = isUnhealthy;
        this.isInactive = isInactive;
        this.isPregnant = isPregnant;
    }

    public boolean isAgeIsYoung() {
        return ageIsYoung;
    }

    public boolean isStressLevelLow() {
        return stressLevelLow;
    }

    public boolean isUnhealthy() {
        return isUnhealthy;
    }

    public boolean isInactive() {
        return isInactive;
    }

    public boolean isPregnant() {
        return isPregnant;
    }
}
