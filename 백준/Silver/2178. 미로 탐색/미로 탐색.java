import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M =  Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for(int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0|| ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                map[nx][ny] = map[x][y] + 1;
                q.add(new int[]{nx, ny});
            }
        }

        System.out.println(map[N-1][M-1]);


    }
}