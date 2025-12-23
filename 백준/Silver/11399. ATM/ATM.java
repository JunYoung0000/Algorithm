import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        // 1. 오름차순 정렬
        Arrays.sort(P);
        
        int sum = 0;      // 누적 시간
        int answer = 0;  // 전체 합
        
        // 2. 누적합 계산
        for (int i = 0; i < N; i++) {
            sum += P[i];
            answer += sum;
        }
        
        System.out.println(answer);
    }
}
