import java.io.FileNotFoundException;
import java.util.Scanner;

public class UserInterface {
    private Controller controller = new Controller();
    private Scanner scanner = new Scanner(System.in).useDelimiter(System.getProperty("line.separator")); //stops errors when using spaces as input

    public UserInterface() throws FileNotFoundException {
    }

    public void run() throws FileNotFoundException {
        controller.loadSuperheroes();
        //Introduction
        System.out.println("Welcome to The Superhero Database");
        //Menu in a loop
        do {
            //Menu items
            System.out.println("\nYou now have the following options:");
            System.out.println("1. Add a superhero");
            System.out.println("2. See all superheroes");
            System.out.println("3. Search by name");
            System.out.println("4. Edit superhero");
            System.out.println("5. Delete superhero");
            System.out.println("6: Sort superhero by name");
            System.out.println("7: Sort superhero by primary and secondary");
            System.out.println("9. Save and exit");

            //User selects option
            System.out.print("I want to: ");
            int menuChoice = getIntInput();

            //Processing choice
            switch (menuChoice) {
                case 1: {
                    addSuperhero();
                    break;
                }
                case 2: {
                    printSuperheroes();
                    break;
                }
                case 3: {
                    searchSuperhero();
                    break;
                }
                case 4: {
                    editSuperhero();
                    break;
                }
                case 5: {
                    deleteSuperhero();
                    break;
                }
                case 6: {
                    sortSuperhero();
                    break;
                }
                case 7: {
                    specifiedSort();
                    break;
                }
                case 9: {

                    controller.saveSuperheroes();
                    System.exit(0);
                }
                default: break;
            }
        } while (true);
    }

    public void specifiedSort() {
        //Menu items
        System.out.println("\nChoose your primary sorting option:");
        System.out.println("1. Name");
        System.out.println("2. Superpower");
        System.out.println("3. Form");
        System.out.println("4. Strength");
        System.out.println("5. Year introduced");



        //User selects option
        System.out.print("I want to: ");
        int primaryChoice = getIntInput();

        //Menu items2
        System.out.println("\nChoose your secondary sorting option:");
        System.out.println("1. Name");
        System.out.println("2. Superpower");
        System.out.println("3. Form");
        System.out.println("4. Strength");
        System.out.println("5. Year introduced");

        //User selects option
        System.out.print("I want to: ");
        int secondaryChoice = getIntInput();

        controller.sortSuperheroes(primaryChoice);
        controller.sortSuperheroes(secondaryChoice);
        printSuperheroes();
    };

    public void sortSuperhero() {
        //Menu items
        System.out.println("\nYou can sort by:");
        System.out.println("1. Name");
        System.out.println("2. Superpower");
        System.out.println("3. Form");
        System.out.println("4. Strength");
        System.out.println("5. Year introduced");

        //User selects option
        System.out.print("I want to: ");
        int sortByChoice = getIntInput();
        controller.sortSuperheroes(sortByChoice);
        printSuperheroes();
    };

    public void addSuperhero() {
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
        controller.addSuperhero(name, superpower, form, yearIntroduced, strength);
    }

    public void editSuperhero() {
        //Edit superhero
        System.out.print("Please enter current name of the superhero to be edited: ");
        String search = scanner.next();
        if (controller.doesExist(search)) {
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
            System.out.println(controller.update(search, name, superpower, form, yearIntroduced, strength));
        } else System.out.println("No match found for " + search);
    }

    public void printSuperheroes() {
        //See all superheroes
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String purple = "\u001B[35m";
        String reset = "\u001B[0m";
        if (controller.getSuperheroes().size() > 0)
            for (Superhero superhero: controller.getSuperheroes()) {
                System.out.printf(red + "Name: %-20s  \u001B[32m Superpower: %-20s \u001B[33m Form: %-10s \u001B[34m Year introduced: %-12s" +
                                "\u001B[35m  Strength: %20s"
                        ,red + superhero.getName()
                        ,green + superhero.getSuperPower()
                        ,yellow + superhero.getForm()
                        ,blue + superhero.getYearIntroduced()
                        ,purple + superhero.getStrength()
                                + reset + "\n");
            }
        else {
            System.out.println("There are no superheroes in the database...");
        }
    }

    public void searchSuperhero() {
        //Search for superhero by name, if more matches, then take first
        System.out.print("Please enter name to search for: ");
        String name = scanner.next();
        if (controller.doesExist(name)) {
            System.out.println(controller.searchSuperhero(name));
        } else {
            System.out.println("No match found for: " + name);
        }
    }

    public void deleteSuperhero() {
        //delete superhero by name
        if (controller.getSuperheroes().size() > 0) {
            System.out.print("Please enter name of the superhero to be deleted: ");
            String search = scanner.next();
            if (controller.doesExist(search)) {
                controller.delete(search);
            }
            else {
                System.out.println("No match found for: " + search);
            }
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