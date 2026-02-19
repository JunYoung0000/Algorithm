import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static int maxSafeCount = 0;
    static int safeCount = 0;
    static int height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (height = 0; height <= 100; height++) {
            visited = new boolean[N][N];
            safeCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && map[i][j] > height) {
                        dfs(i, j);
                        safeCount++;
                    }
                }
            }

            if(safeCount > maxSafeCount){
                maxSafeCount = safeCount;
            }
        }

        System.out.println(maxSafeCount);
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if(ny >= 0 && nx >= 0 && ny < N && nx < N){
                if(!visited[ny][nx] && map[ny][nx] > height){
                    dfs(ny, nx);
                }
            }
        }
    }
}
