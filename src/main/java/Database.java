import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes;
    public Database() {
        this.superheroes = new ArrayList<Superhero>();
    }

    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new Superhero(name, superpower, form, yearIntroduced, strength));
    }

    public void update(Superhero superhero) {
        this.superheroes.add(superhero);
    }
    public void delete(Superhero superhero) {
        this.superheroes.add(superhero);
    }
}
