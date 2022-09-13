import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes;
    public Database() {
        this.superheroes = new ArrayList<Superhero>();
    }

    public void printList() {
        if (this.superheroes.size() > 0) {
            for (int i = 0; i < this.superheroes.size(); i++) {
                System.out.println("#" + i + ": " + superheroes.get(i));
            }
        } else {
            System.out.println("There are no superheroes in the database...");
        }
    }
    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }

    public void addSuperhero(Superhero superhero) {
        this.superheroes.add(superhero);
    }

    public void update(Superhero superhero) {
        this.superheroes.add(superhero);
    }
    public void delete(Superhero superhero) {
        this.superheroes.add(superhero);
    }
}
