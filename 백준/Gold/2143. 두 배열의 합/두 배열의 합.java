import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) B[i] = Integer.parseInt(st.nextToken());

        // B의 부배열 합 → 개수 저장
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        long answer = 0;

        // A의 부배열 합 보면서 바로 계산
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                answer += map.getOrDefault(T - sum, 0);
            }
        }

        System.out.println(answer);
    }
}
