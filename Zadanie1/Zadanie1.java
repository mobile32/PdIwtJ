import java.util.Random;
import java.util.Scanner;

public class Zadanie1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Podaj wyraz początkowy");
        double a1 = Double.parseDouble(input.nextLine());
        System.out.println("Podaj ilość wyrazów");
        int n = Integer.parseInt(input.nextLine());
        int r = randInt(1, 50);
        System.out.println("Wylosowana różnica " + r);

        double an = a1 + (n - 1) * r;
        double sn = ((a1 + an) / 2) * n;

        System.out.println("Wynik " + sn);
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
