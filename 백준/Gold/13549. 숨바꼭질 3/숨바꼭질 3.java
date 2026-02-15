import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        Deque<Integer> dq = new ArrayDeque<>();

        dq.offer(N);
        dist[N] = 0;
        while (!dq.isEmpty()) {
            int now = dq.poll();

            if (now == K) {
                System.out.println(dist[now]);
                return;
            }

            int teleport = now * 2;
            if(teleport >= 0 && teleport <= MAX && dist[teleport] > dist[now]) {
                dist[teleport] = dist[now];
                dq.offerFirst(teleport);
            }

            int plus = now + 1;
            if(plus <= MAX && dist[plus] > dist[now] + 1) {
                dist[plus] = dist[now] + 1;
                dq.offerLast(plus);
            }

            int minus = now - 1;
            if(minus >= 0 && dist[minus] > dist[now] + 1) {
                dist[minus] = dist[now] + 1;
                dq.offerLast(minus);
            }
        }
    }
}
