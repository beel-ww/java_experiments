import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    static void main(String[] args) {
        try {reader("src/DinoDiet.txt");}
        catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        badArgs(-1, "Joe");
        badArgs(15, "Jeep");
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
    private int age;
    final private String name;

    Dinosaur(int age, String name) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }

        this.age = age;
        this.name = name;
    }

    void setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        } else {
            this.age = age;
        }
    }

    String getInfo() {
        return this.name + " is " + this.age + " years old.";
    }
}