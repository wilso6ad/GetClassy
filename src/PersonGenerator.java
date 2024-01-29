import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;

public class PersonGenerator {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        ArrayList<Person> people = new ArrayList<>();
        int index = 1;

        while (SafeInput.getYNConfirm(in, "Create new Person object?")) {
            System.out.println("First name: ");
            String firstName = in.nextLine();
            System.out.println("\nLast name: ");
            String lastName = in.nextLine();
            System.out.println("\nTitle: ");
            String title = in.nextLine();
            System.out.println("\nYear of birth: ");
            int YOB = in.nextInt();

            people.add(new Person(Integer.toString(index), firstName, lastName, title, YOB));

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