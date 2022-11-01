import org.testng.annotations.Test;

import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes;

    public Database() {
        this.superheroes = new ArrayList<>();
    }

    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new Superhero(name, superpower, form, yearIntroduced, strength));
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
