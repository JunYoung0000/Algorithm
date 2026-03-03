import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        List<Integer> list = new ArrayList<>();

        int[] arr = new int[10];
        int num;
        for (int i = 0; i < input.length(); i++) {
            num = Integer.parseInt(String.valueOf(input.charAt(i)));

            if (num == 6 || num == 9) {
                arr[6] += 1;
            } else {
                arr[num] += 1;
            }
        }

        int MAX = 0;
        int sum = 0;

        for (int i = 0; i <= 9; i++) {
            if (i == 6) {
                sum = arr[i] % 2 == 0 ? arr[i] / 2 : arr[i] / 2 + 1;
                if (MAX < (sum)) {
                    MAX = sum;
                }
            } else {
                sum = arr[i];
                if (MAX < sum) {
                    MAX = sum;
                }
            }
        }

        System.out.println(MAX);
    }
}

