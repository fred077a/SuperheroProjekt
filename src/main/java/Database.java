import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Database {
    private ArrayList<Superhero> superheroes;
    private boolean changesMade = false;

    public Database() {
        this.superheroes = new ArrayList<>();
    }

    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }


    public boolean getChangesMade() {
        return changesMade;
    }

    public void setChangesMade() {
        this.changesMade = true;
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new Superhero(name, superpower, form, yearIntroduced, strength));
        setChangesMade();
    }
    public void addSuperhero(Superhero superhero) {
        this.superheroes.add(superhero);
    }

    public void delete(String name) {
        for (Superhero superhero: superheroes) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                superheroes.remove(superhero);
                break;
            }
        }
    }

    public void sortSuperheroes(int choice) {
        Collections.sort(superheroes, new Comparator<Superhero>() {
            @Override
            public int compare(Superhero s1, Superhero s2) {
                switch (choice) {
                    case 1: {
                        return String.valueOf(s1.getName()).compareTo(String.valueOf(s2.getName()));
                    }
                    case 2: {
                        return String.valueOf(s1.getSuperPower()).compareTo(String.valueOf(s2.getSuperPower()));
                    }
                    case 3: {
                        return String.valueOf(s1.getForm()).compareTo(String.valueOf(s2.getForm()));
                    }
                    case 4: {
                        return Double.valueOf(s1.getStrength()).compareTo(Double.valueOf(s2.getStrength()));
                    }
                    case 5: {
                        return s1.getYearIntroduced() - s2.getYearIntroduced();
                    }
                    default: {
                        return String.valueOf(s1.getName()).compareTo(String.valueOf(s2.getName()));
                    }
                }
            }
        });
    }
}
