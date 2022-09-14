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
    String getSuperPower() {
        return this.superPower;
    }
    String getHumanForm() {
        return this.form;
    }
    int getYearIntroduced() {
        return this.yearIntroduced;
    }
    double getStrength() {
        return this.strength;
    }
}
