import org.testng.annotations.Test;

import java.util.ArrayList;

public class Database {
    private ArrayList<Superhero> superheroes;
    public Database() {
        this.superheroes = new ArrayList<Superhero>();
    }
    public ArrayList<Superhero> getSuperheroes() {
        return this.superheroes;
    }
    public String searchSuperhero(String search) {
        String result = "";
        for (Superhero superhero: this.superheroes) {
            if (superhero.getName().toLowerCase().contains(search)) result = result + superhero + "\n";
        }
        return result;
    }
    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        this.superheroes.add(new Superhero(name, superpower, form, yearIntroduced, strength));
    }
    public boolean doesExist(String search) {
        boolean doesExist = false;
        for (Superhero superhero: this.superheroes) {
            if (superhero.getName().toLowerCase().contains(search)) {
                doesExist = true;
                break;
            }
        }
        return doesExist;
    }
    public String update(String search, String name, String superPower, String form, String yearIntroduced, String strength) {
        String result = "";
        for (Superhero superhero: this.superheroes) {
            if (superhero.getName().toLowerCase().contains(search)) {
                if (!name.isEmpty()) superhero.setName(name);
                if (!superPower.isEmpty()) superhero.setSuperPower(superPower);
                if (!form.isEmpty()) superhero.setForm(form);
                if (!yearIntroduced.isEmpty()) superhero.setYearIntroduced(Integer.parseInt(yearIntroduced));
                if (!strength.isEmpty()) superhero.setStrength(Double.parseDouble(strength));
                result = superhero.toString();
            }
        }
        return result;
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
