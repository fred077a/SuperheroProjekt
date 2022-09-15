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
    public String toString() {
        final String green = "\u001B[32m";
        final String yellow = "\u001B[33m";
        final String red = "\u001B[31m";
        final String blue = "\u001B[34m";
        final String purple = "\u001B[35m";
        final String resetText = "\u001B[0m";
        return green + "Name: " + this.name + ", " + resetText
                + yellow + "Form: " + this.form + ", " + resetText
                + red + "Superpower: " + this.superPower + ", " + resetText
                + blue +  "Strength: " + this.strength + ", " + resetText
                + purple + "Year introduced: " + this.yearIntroduced + resetText;
    }

    String getName() {
        return this.name;
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
