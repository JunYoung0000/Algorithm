import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dist = new int[n][m];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int fx = 0, fy = 0;

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 2){
                    fx = j;
                    fy = i;
                }
                map[i][j] = num;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{fy, fx});
        dist[fy][fx] = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && dist[ny][nx] == -1 && map[ny][nx] == 1){
                    dist[ny][nx] = dist[y][x] + 1;
                    q.add(new int[]{ny, nx});
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] == 0) sb.append(0);
                else sb.append(dist[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}