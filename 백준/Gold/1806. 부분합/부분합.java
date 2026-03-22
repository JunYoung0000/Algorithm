import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < N; right++) {
            sum += arr[right]; // 1️⃣ 오른쪽 확장

            while (sum >= S) { // 2️⃣ 조건 만족하면
                minLen = Math.min(minLen, right - left + 1); // 3️⃣ 길이 갱신
                sum -= arr[left]; // 4️⃣ 왼쪽 제거
                left++;           // 5️⃣ 구간 축소
            }
        }

        System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}