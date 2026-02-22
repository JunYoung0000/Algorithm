import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int maxExtent = 0, count, extent;
    static int n, m;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    count++;
                    extent = 0;
                    dfs(i, j);
                    if(maxExtent < extent) maxExtent = extent;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxExtent);
    }

    static void dfs(int y, int x){
        visited[y][x] = true;
        extent++;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    dfs(ny, nx);
                }
            }
        }
    }
}
