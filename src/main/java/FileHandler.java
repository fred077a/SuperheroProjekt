import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private File file = new File("data/list.csv");

    public void saveList(ArrayList<Superhero> superheroes) throws FileNotFoundException {
        PrintStream output = new PrintStream(this.file);
        for (Superhero superhero: superheroes) {
            output.print(superhero.getName());
            output.print(";");
            output.print(superhero.getForm());
            output.print(";");
            output.print(superhero.getSuperPower());
            output.print(";");
            output.print(superhero.getStrength());
            output.print(";");
            output.print(superhero.getYearIntroduced());
            output.println();
        }
        output.flush();
        output.close();
    }

    public ArrayList<Superhero> loadList() throws FileNotFoundException {
        Scanner scanner = new Scanner(this.file);
        String data = "-nothing yet-";
        ArrayList<Superhero> superheroes = new ArrayList<>();
        while(!data.isBlank() && scanner.hasNextLine()) {
            data = scanner.nextLine();
            String[] lines = data.split("\\n");
            for (int i = 0; i < lines.length; i++) {
                String[] attributes = lines[i].split(";");
                superheroes.add(
                        new Superhero(
                                attributes[0],
                                attributes[1],
                                attributes[2],
                                Integer.parseInt(attributes[4]),
                                Double.parseDouble(attributes[3]))
                );
            }
        }
        return superheroes;
    }
}
