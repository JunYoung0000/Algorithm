import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (q.size() > 1) {
            // 1. 제일 위 카드를 버림
            sb.append(q.poll()).append(" ");

            // 2. 다음 카드를 뒤로 옮김
            q.offer(q.poll());
        }

        // 마지막으로 남은 카드
        sb.append(q.poll());

        System.out.println(sb.toString());
    }
}
