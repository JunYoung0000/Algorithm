import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                answer += N / 5;
                System.out.println(answer);
                return;
            } else {
                N -= 3;
                answer++;
            }
        }

        System.out.println(-1);
    }
}
