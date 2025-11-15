import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        // 첫 줄: 버퍼 크기 N
        line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line.trim());

        Deque<Integer> q = new ArrayDeque<>(N);

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.length() == 0) continue;
            int x = Integer.parseInt(line);
            if (x == -1) break;

            if (x == 0) {
                // 라우터가 패킷 하나 처리: 큐에서 앞의 요소 제거 (비어있으면 아무 동작 없음)
                if (!q.isEmpty()) q.pollFirst();
            } else if (x > 0) {
                // 패킷이 들어옴: 버퍼 여유가 있으면 추가, 없으면 버림
                if (q.size() < N) q.addLast(x);
            }
        }

        if (q.isEmpty()) {
            System.out.println("empty");
        } else {
            StringBuilder sb = new StringBuilder();
            while (!q.isEmpty()) {
                sb.append(q.pollFirst());
                if (!q.isEmpty()) sb.append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
