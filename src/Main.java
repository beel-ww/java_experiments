import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        try {reader("src/DinoDiet.txt");}
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        badArgs(-1, "Joe");
        badArgs(15, "Joe");
    }

    public static void reader(String filename) throws IOException {
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader br = new BufferedReader(fileReader)) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error opening file " + filename);
        }
    }

    public static void badArgs(int age, String name) throws IllegalArgumentException {
        try {
            Dinosaur d = new Dinosaur(age, name);
            System.out.println(d.getInfo());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Dinosaur {
    final private int age;
    final private String name;

    Dinosaur(int age, String name) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
        this.name = name;
    }

    String getInfo() {
        return this.name + " is " + this.age + " years old.";
    }
}