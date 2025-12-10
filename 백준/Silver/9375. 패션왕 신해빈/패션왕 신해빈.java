import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] arr = br.readLine().split(" ");
                String type = arr[1];
                map.put(type, map.getOrDefault(type, 0) + 1);
            }

            int result = 1;

            for (int count : map.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }
    }
}
