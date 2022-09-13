import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Introduction
        System.out.println("Welcome to Superhero Database");

        //Variables
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.getProperty("line.separator")); //stops errors when using spaces as input
        Database database = new Database();

        //Menu in a loop
        do {
            //Menu items
            System.out.println("You now have the following options:");
            System.out.println("1. Add a superhero");
            System.out.println("2. See all superheroes");
            System.out.println("9. Exit");

            //User selects
            System.out.print("I want to... ");
            int menuChoice = scanner.nextInt();

            //Processing choice
            if (menuChoice == 1) {
                //Add superhero
                System.out.print("Enter superhero name: ");
                String name = scanner.next();
                System.out.print("Enter superpower: ");
                String superpower = scanner.next();
                System.out.print("Enter form (human, alien etc.): ");
                String form = scanner.next();
                System.out.print("Enter year introduced: ");
                int yearIntroduced = scanner.nextInt();
                System.out.print("Enter strength: ");
                double strength = scanner.nextDouble();
                database.addSuperhero(new Superhero(name, superpower, form, yearIntroduced, strength));
            } else if (menuChoice == 2) {
                //See all superheroes
                ArrayList<Superhero> superheroes = database.getSuperheroes();
                if (superheroes.size() > 0) {
                    for (int i = 0; i < superheroes.size(); i++) System.out.println("#" + i + ": " + superheroes.get(i));
                } else System.out.println("There are no superheroes in the database...");
            } else break; //Code has been exited
        } while (true);
    }
}