import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class ProductRea {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                Scanner sc = new Scanner(file);
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] data = line.split(",");
                    System.out.format("ID: %s, name of product: %s, Description: %s, Cost: %s\n", data[0], data[1], data[2], data[3]);
                }
                sc.close();
            } catch (FileNotFoundException e) {
                System.out.println("Error reading file " + file.getName());
            }
        }
    }
}