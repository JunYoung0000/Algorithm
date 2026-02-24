import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        int diagonal = 0;
        int sum = 0;

        while (sum < X) {
            diagonal++;
            sum += diagonal;
        }

        int offset = sum - X;
        int numerator, denominator;

        if (diagonal % 2 == 0) {
            numerator = diagonal - offset;
            denominator = 1 + offset;

        } else {
            numerator = 1 + offset;
            denominator = diagonal - offset;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
