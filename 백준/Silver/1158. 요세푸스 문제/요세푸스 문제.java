import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" "); // 입력을 공백 기준으로 분리

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        sb.append('<');

        // 큐가 빌 때까지 반복
        while (!q.isEmpty()) {
            // K-1명은 뒤로 보냄
            for (int i = 0; i < K - 1; i++) {
                q.offer(q.poll());
            }

            // K번째 사람 제거
            sb.append(q.poll());

            if (!q.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append('>');
        System.out.println(sb);
    }
}
