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
}
