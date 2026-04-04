import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(N);
        dist[N] = 0;

        while(!dq.isEmpty()){
            int cur = dq.poll();

            if (cur == K){
                System.out.println(dist[cur]);
                return;
            }

            int next = cur * 2;
            if (next <= MAX && dist[next] > dist[cur]){
                dist[next] = dist[cur];
                dq.addFirst(next);
            }

            next = cur - 1;
            if (next >= 0 && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }

            next = cur + 1;
            if (next <= MAX && dist[next] > dist[cur] + 1){
                dist[next] = dist[cur] + 1;
                dq.addLast(next);
            }
        }
    }
}