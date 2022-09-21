import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Database database = new Database();
    private Scanner scanner = new Scanner(System.in).useDelimiter(System.getProperty("line.separator")); //stops errors when using spaces as input

    public void run() {
        //Introduction
        System.out.println("Welcome to Superhero Database");

        //For testing purposes:
        database.addSuperhero("Superman", "Laser", "Alien", 1950, 12000);
        database.addSuperhero("Spider-man", "Strength", "Human", 1970, 2000);
        database.addSuperhero("Batman", "Rich", "Human", 1939, 100);

        //Menu in a loop
        do {
            //Menu items
            System.out.println("\nYou now have the following options:");
            System.out.println("1. Add a superhero");
            System.out.println("2. See all superheroes");
            System.out.println("3. Search by name");
            System.out.println("4. Edit superhero");
            System.out.println("5. Delete superhero");
            System.out.println("9. Exit");

            //User selects option
            System.out.print("I want to: ");
            int menuChoice = getIntInput();

            //Processing choice
            if (menuChoice == 1) this.addSuperhero();
            else if (menuChoice == 2) this.getSuperheroes();
            else if (menuChoice == 3 ) this.searchSuperhero();
            else if (menuChoice == 4 ) this.editSuperhero();
            else if (menuChoice == 5 ) this.deleteSuperhero();
            else break; //Program has been exited
        } while (true);
    }
    public void addSuperhero() {
        //Add superhero
        System.out.print("Enter superhero name: ");
        String name = scanner.next();
        System.out.print("Enter superpower: ");
        String superpower = scanner.next();
        System.out.print("Enter form (human, alien etc.): ");
        String form = scanner.next();
        System.out.print("Enter year introduced: ");
        int yearIntroduced = getIntInput();
        System.out.print("Enter strength: ");
        double strength = getDoubleInput();
        database.addSuperhero(name, superpower, form, yearIntroduced, strength);
    }
    public void getSuperheroes() {
        //See all superheroes
        if (database.getSuperheroes().size() > 0)
            for (Superhero superhero: database.getSuperheroes()) System.out.println(superhero);
        else System.out.println("There are no superheroes in the database...");
    }
    public void searchSuperhero() {
        //Search for superhero by name, if more matches, then take first
        System.out.print("Please enter name to search for: ");
        String name = scanner.next();
        if (database.doesExist(name))
            System.out.println(database.searchSuperhero(name));
        else System.out.println("No match found for: " + name);
    }
    public void editSuperhero() {
        //Edit superhero
        System.out.print("Please enter current name of the superhero to be edited: ");
        String search = scanner.next();
        if (database.doesExist(search)) {
            //exists
            System.out.print("Enter new superhero name: ");
            String name = scanner.next();
            System.out.print("Enter new superpower: ");
            String superpower = scanner.next();
            System.out.print("Enter new form (human, alien etc.): ");
            String form = scanner.next();
            System.out.print("Enter new year introduced: ");
            String yearIntroduced = scanner.next();
            System.out.print("Enter new strength: ");
            String strength = scanner.next();
            System.out.print("Superhero was changed to: ");
            System.out.println(database.update(search, name, superpower, form, yearIntroduced, strength));
        } else System.out.println("No match found for " + search);
    }
    public void deleteSuperhero() {
        //delete superhero by name
        if (database.getSuperheroes().size() > 0) {
            System.out.print("Please enter name of the superhero to be deleted: ");
            String search = scanner.next();
            if (database.doesExist(search)) database.delete(search);
            else System.out.println("No match found for: " + search);
        } else System.out.println("There are no superheroes in the database...");
    }
    private int getIntInput() {
        do {
            try {
                int num = new Scanner(System.in).nextInt();
                return num;
            } catch (Exception ex) {
                System.out.print("Sorry, but you need to enter a number: ");
            }
        } while (true);
    }
    private double getDoubleInput() {
        do {
            try {
                double num = new Scanner(System.in).nextDouble();
                return num;
            } catch (Exception ex) {
                System.out.print("Sorry, but you need to enter a number: ");
            }
        } while (true);
    }
}