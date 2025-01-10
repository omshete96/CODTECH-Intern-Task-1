import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    private static final String FILE_NAME = "example.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Handling Utility");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Modify file");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                writeFile(scanner);
                break;
            case 2:
                readFile();
                break;
            case 3:
                modifyFile(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
        scanner.close();
    }

    /**
     * Writes user-provided text to the file.
     */
    private static void writeFile(Scanner scanner) {
        System.out.print("Enter text to write to the file: ");
        String content = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the content of the file.
     */
    private static void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Appends user-provided text to the file, demonstrating modification.
     */
    private static void modifyFile(Scanner scanner) {
        System.out.print("Enter text to append to the file: ");
        String content = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine();
            writer.write(content);
            System.out.println("Text appended to file successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}
