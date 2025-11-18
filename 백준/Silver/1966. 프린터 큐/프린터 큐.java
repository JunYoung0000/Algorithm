import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String[] str = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]); // 문서 개수
            int M = Integer.parseInt(str[1]); // 찾는 문서 위치

            String[] priorities = br.readLine().split(" ");

            Queue<int[]> q = new LinkedList<>();

            // 문서를 [원래 위치, 우선순위] 형태로 큐에 저장
            for (int i = 0; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(priorities[i])});
            }

            int printOrder = 0; // 인쇄된 순서

            while (!q.isEmpty()) {
                int[] current = q.poll();
                int curIdx = current[0];
                int curPri = current[1];

                boolean hasHigher = false;

                // 현재 문서보다 높은 우선순위가 있는지 검사
                for (int[] doc : q) {
                    if (doc[1] > curPri) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    // 우선순위 높은 문서가 있음 → 뒤로 보냄
                    q.offer(current);
                } else {
                    // 인쇄됨
                    printOrder++;

                    // 찾던 문서면 출력
                    if (curIdx == M) {
                        sb.append(printOrder).append("\n");
                        break;
                    }
                }
            }
        }

        System.out.print(sb.toString());
    }
}
