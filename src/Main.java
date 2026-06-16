import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TeamSystem engine = new TeamSystem(scanner);
        engine.start();
        scanner.close();
        System.out.println("I'll wait for u :)");
    }
}