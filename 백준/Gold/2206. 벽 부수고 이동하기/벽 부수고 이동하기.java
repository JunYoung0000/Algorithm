import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Node {
        int x, y, broken, dist;

        Node(int x, int y, int broken, int dist) {
            this.x = x;
            this.y = y;
            this.broken = broken; // 0: 아직 안 부숨, 1: 이미 부숨
            this.dist = dist;     // 현재까지 거리
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.dist;
            }

            for (int d = 0; d < 4; d++){
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 && !visited[nx][ny][now.broken]) {
                    visited[nx][ny][now.broken] = true;
                    q.add(new Node(nx, ny, now.broken, now.dist + 1));
                }

                if (map[nx][ny] == 1 && now.broken == 0 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.add(new Node(nx, ny, 1, now.dist + 1));
                }
            }
        }

        return -1;
    }
}
