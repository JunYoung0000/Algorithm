import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int M;
    static int N;
    static int T;
    static int K;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            count = 0;
            map = new int[N][M];
            visited = new boolean[N][M];

            for(int k = 0; k < K; k++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int y, int x){
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx >= 0 && ny >= 0 && nx < M && ny < N){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }
    }
}
