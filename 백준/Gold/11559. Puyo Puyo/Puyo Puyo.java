import java.io.*;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr = new char[12][6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;

        while (true) {
            boolean isPopped = false;
            boolean[][] visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (arr[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j, visited)) {
                            isPopped = true;
                        }
                    }
                }
            }

            if (!isPopped) break;

            gravity();
            count++;
        }

        System.out.println(count);
    }

    static boolean bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();

        q.add(new int[]{x, y});
        list.add(new int[]{x, y});
        visited[x][y] = true;

        char color = arr[x][y];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6) {
                    if (!visited[nx][ny] && arr[nx][ny] == color) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        list.add(new int[]{nx, ny});
                    }
                }
            }
        }

        if (list.size() >= 4) {
            for (int[] p : list) {
                arr[p[0]][p[1]] = '.';
            }
            return true;
        }

        return false;
    }

    static void gravity() {
        for (int j = 0; j < 6; j++) {
            for (int i = 11; i >= 0; i--) {
                if (arr[i][j] == '.') {
                    for (int k = i - 1; k >= 0; k--) {
                        if (arr[k][j] != '.') {
                            arr[i][j] = arr[k][j];
                            arr[k][j] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}