import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 1️⃣ 정상인 시야
        visited = new boolean[N][N];
        int normalCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfsNormal(i, j);
                    normalCount++;
                }
            }
        }

        // 2️⃣ 적록색약 시야
        visited = new boolean[N][N];
        int colorBlindCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfsColorBlind(i, j);
                    colorBlindCount++;
                }
            }
        }

        System.out.println(normalCount + " " + colorBlindCount);
    }

    // 🔹 일반 시야 BFS
    static void bfsNormal(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        char color = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }

    // 🔹 적록색약 BFS
    static void bfsColorBlind(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;

        char color = map[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;

                // 적록색약 조건
                if (color == 'B') {
                    if (map[nx][ny] != 'B') continue;
                } else { // R or G
                    if (map[nx][ny] == 'B') continue;
                }

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}
