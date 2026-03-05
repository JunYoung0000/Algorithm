import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            arr[i] = arr[i-1] + arr[i];
        }

        int MAX = Integer.MIN_VALUE;
        for(int i = 1; i <= N - K + 1; i++){
            int sum = 0;

            sum = arr[i + K - 1] - arr[i - 1];

            if(MAX < sum) MAX = sum;
        }

        System.out.println(MAX);
    }
}

