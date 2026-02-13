import java.io.*;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();

    // 6방향 (위, 아래, 앞, 뒤, 좌, 우)
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];

        // 입력
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[h][i][j] = Integer.parseInt(st.nextToken());

                    // 익은 토마토면 큐에 추가 (다중 시작점)
                    if (map[h][i][j] == 1) {
                        queue.add(new int[]{h, i, j});
                    }
                }
            }
        }

        bfs();

        int answer = 0;

        // 결과 확인
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[h][i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, map[h][i][j]);
                }
            }
        }

        // 처음이 1이므로 -1 해줘야 실제 날짜
        System.out.println(answer - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int z = now[0];
            int x = now[1];
            int y = now[2];

            for (int d = 0; d < 6; d++) {
                int nz = z + dz[d];
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nz >= 0 && nz < H &&
                    nx >= 0 && nx < N &&
                    ny >= 0 && ny < M) {

                    if (map[nz][nx][ny] == 0) {
                        map[nz][nx][ny] = map[z][x][y] + 1;
                        queue.add(new int[]{nz, nx, ny});
                    }
                }
            }
        }
    }
}
