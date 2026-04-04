import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int to, cost;

        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node o){
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<Node>[] graph;
    static int N, E;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        long case1 = (long)dist1[v1] + distV1[v2] + distV2[N];
        long case2 = (long)dist1[v2] + distV2[v1] + distV1[N];

        long answer;

        if(dist1[v1] == INF || distV1[v2] == INF || distV2[N] == INF)
            case1 = INF;
        if(dist1[v2] == INF || distV2[v1] == INF || distV1[N] == INF)
            case2 = INF;

        answer = Math.min(case1, case2);

        if(answer >= INF) System.out.println(-1);
        else System.out.println(answer);
    }

    static int[] dijkstra(int start){
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to] < cur.cost) continue;

            for(Node next : graph[cur.to]){
                int nextCost = cur.cost + next.cost;

                if(nextCost < dist[next.to]){
                    dist[next.to] = nextCost;
                    pq.offer(new Node(next.to, nextCost));
                }
            }
        }

        return dist;
    }
}