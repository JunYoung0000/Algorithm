import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr =  br.readLine().toCharArray();

        int sum = 0;
        boolean hasZero = false;
        for(char c : arr){
            int n = c - '0';
            sum += n;

            if(n == 0) hasZero = true;
        }

        if (!hasZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i = arr.length - 1; i >= 0; i--){
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}