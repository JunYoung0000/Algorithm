import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] replace = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String st : replace) {
            input = input.replace(st, "x");

        }
        System.out.println(input.length());
    }
}
