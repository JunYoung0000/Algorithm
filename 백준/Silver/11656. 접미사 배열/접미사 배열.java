import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int size = S.length();

        String[] str = new String[size];

        for(int i = 0; i < size; i++) {
            str[i] = S.substring(i);
        }

        Arrays.sort(str);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(str[i]).append("\n");
        }

        System.out.println(sb);
    }
}