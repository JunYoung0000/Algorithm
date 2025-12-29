import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            A[i] = n;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            B[i] = n;
        }

        Arrays.sort(B);
        Arrays.sort(A);

        int sum = 0;
        for(int i = 0; i < N; i++){
            sum += (A[N -i - 1] * B[i]);
        }

        System.out.println(sum);
    }
}