import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();

            // 뒤에서부터 돌기 (핵심)
            for (int w = K; w >= weight; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }

        System.out.println(dp[K]);
    }
}