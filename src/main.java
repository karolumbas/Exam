import java.io.File;
import java.io.FileInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        File file = new File("myFile.txt");

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            User user = scanUser();
            writeToFile(user, file);
            readToFile(file);

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static User scanUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Suveskite duomenis");
        System.out.println("Vardas: ");
        String name = scanner.nextLine();
        System.out.println("Pavarde: ");
        String surname = scanner.nextLine();
        System.out.println("Asmens kodas: ");
        long ak = scanner.nextLong();

        return new User(name, surname, ak);
    }

    private static void writeToFile(User user, File file) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FilterOutputStream(file))) {
            output.writeObject(user);
            output.flush();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void readToFile(File file) {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                User user = (User) input.readObject();
                if (user instanceof User) {
                    System.out.println(user);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
