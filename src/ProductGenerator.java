import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class ProductGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int index = 1;

        while (SafeInput.getYNConfirm(in, "Create new Product object?")) {
            System.out.println(" ID: ");
            String firstName = in.nextLine();
            System.out.println("\n Name: ");
            String lastName = in.nextLine();
            System.out.println("\n Description: ");
            String title = in.nextLine();
            System.out.println("\n Cost: ");
            double cost = in.nextInt();

            people.add(new Person(Integer.toString(index), firstName, lastName, title, (int) cost));

            index++;
        }

        System.out.println("\nEnter output file name: ");
        String outputFileName = in.nextLine();
        PrintWriter out = new PrintWriter(outputFileName);

        for (Person person : people) {
            out.println(person.toCSVDataRecord());
        }

        out.close();
    }
}