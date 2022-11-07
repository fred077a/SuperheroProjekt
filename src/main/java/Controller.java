import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    private Database database = new Database();
    private FileHandler fileHandler = new FileHandler();

    public Controller() throws FileNotFoundException {
    }

    public void addSuperhero(String name, String superpower, String form, int yearIntroduced, double strength) {
        database.addSuperhero(name, superpower, form, yearIntroduced, strength);
    }

    public ArrayList<Superhero> getSuperheroes() {
        return database.getSuperheroes();
    }

    public boolean doesExist(String search) {
        boolean doesExist = false;
        for (Superhero superhero: database.getSuperheroes()) {
            if (superhero.getName().toLowerCase().contains(search)) {
                doesExist = true;
                break;
            }
        }
        return doesExist;
    }


    public void saveSuperheroes() throws FileNotFoundException {
        boolean changesMade = database.getChangesMade();
        if (changesMade) {
            ArrayList<Superhero> superheroes = database.getSuperheroes();
            fileHandler.saveList(superheroes);
        }
    }

    public void loadSuperheroes() throws FileNotFoundException {
        ArrayList<Superhero> superheroes = fileHandler.loadList();
        for (Superhero superhero: superheroes) {
            database.addSuperhero(superhero);
        }
    }

    public String searchSuperhero(String search) {
        StringBuilder result = new StringBuilder();
        for (Superhero superhero: database.getSuperheroes()) {
            String superheroName = superhero.getName().toLowerCase();
            if (superheroName.contains(search)) {
                result.append(superhero).append("\n");
            }
        }
        return result.toString();
    }
    public String update(String search, String name, String superPower, String form, String yearIntroduced, String strength) {
        String result = "";
        for (Superhero superhero: database.getSuperheroes()) {
            if (superhero.getName().toLowerCase().contains(search)) {
                if (!name.isEmpty()) {
                    superhero.setName(name);
                }
                if (!superPower.isEmpty()) {
                    superhero.setSuperPower(superPower);
                }
                if (!form.isEmpty()) {
                    superhero.setForm(form);
                }
                if (!yearIntroduced.isEmpty()) {
                    superhero.setYearIntroduced(Integer.parseInt(yearIntroduced));
                }
                if (!strength.isEmpty()) {
                    superhero.setStrength(Double.parseDouble(strength));
                }
                result = superhero.toString();
            }
            database.setChangesMade();
        }
        return result;
    }

    public void delete(String name) {
        for (Superhero superhero: database.getSuperheroes()) {
            if (superhero.getName().toLowerCase().contains(name.toLowerCase())) {
                database.delete(name);
                break;
            }
        }
    }

    public void sortSuperheroes(int choice) {
        database.sortSuperheroes(choice);
    }
}
