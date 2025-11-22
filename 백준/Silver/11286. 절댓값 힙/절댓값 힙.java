import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> {
                    // 절댓값이 큰 순서
                    int comp = Integer.compare(Math.abs(a), Math.abs(b));
                    if (comp == 0) {
                        // 절댓값이 같으면 더 큰 수를 우선
                        return Integer.compare(a, b);
                    }
                    return comp;
                }
        );

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            if(N == 0){
                if(pq.isEmpty()) sb.append(0).append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.offer(N);
            }
        }

        System.out.print(sb.toString());
    }
}
