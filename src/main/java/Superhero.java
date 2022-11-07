public class Superhero {
    private String name;
    private String superPower;
    private String form;
    private int yearIntroduced;
    private double strength;

    public Superhero(String name, String superPower, String humanForm, int yearIntroduced, double strength) {
        this.name = name;
        this.superPower = superPower;
        this.form = humanForm;
        this.yearIntroduced = yearIntroduced;
        this.strength = strength;
    }

    String getName() {
        return this.name;
    }
    String getForm() {
        return this.form;
    }
    String getSuperPower() {
        return this.superPower;
    }
    double getStrength() {
        return this.strength;
    }
    int getYearIntroduced() {
        return this.yearIntroduced;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setYearIntroduced(int yearIntroduced) {
        this.yearIntroduced = yearIntroduced;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    void updateSuperhero(String name, String superPower, String humanForm, int yearIntroduced, double strength) {
        this.name = name;
        this.superPower = superPower;
        this.form = humanForm;
        this.yearIntroduced = yearIntroduced;
        this.strength = strength;
    }
}
