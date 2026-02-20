import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static StringTokenizer st;
    static int w, h;

    static int count = 0;
    static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        count++;
                        dfs(i, j);
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x){
        visited[y][x] = true;

        for(int d = 0; d < 8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < w && ny < h){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    dfs(ny, nx);
                }
            }
        }
    }
}
