import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int N, L, R;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;

        while(true){
            visited = new boolean[N][N];
            boolean moved = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if(bfs(i, j)){
                            moved = true;
                        }
                    }

                }
            }

            if(!moved) break;
            day++;
        }

        System.out.println(day);
    }

    static boolean bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        List<Node> union = new ArrayList<>();

        q.add(new Node(x, y));
        union.add(new Node(x, y));
        visited[x][y] = true;

        int sum = map[x][y];

        while(!q.isEmpty()){
            Node cur = q.poll();

            for (int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                int diff = Math.abs(map[cur.x][cur.y] - map[nx][ny]);

                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny));
                    union.add(new Node(nx, ny));
                    sum += map[nx][ny];
                }

            }
        }

        if (union.size() == 1) return false;

        int avg = sum / union.size();

        for (Node n : union){
            map[n.x][n.y] = avg;
        }

        return true;
    }
}