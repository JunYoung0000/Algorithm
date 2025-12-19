import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < T; i++){
            HashSet<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int n = 0; n < N; n++) {
                set.add(Integer.parseInt(st.nextToken()));
            }

            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int m = 0; m < M; m++){
                if(set.contains(Integer.parseInt(st.nextToken()))) sb.append("1\n");
                else sb.append("0\n");
            }
        }

        System.out.println(sb);
    }
}