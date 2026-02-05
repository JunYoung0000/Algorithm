import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[][] map = new int[N+1][M+1];
        boolean[][] visited = new boolean[N+1][M+1];

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = 1;
        }

        Queue<int[]> q = new ArrayDeque<>();
        int maxCount = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        int x = cur[1];
                        int y = cur[0];

                        for(int d = 0; d < 4; d++){
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if(nx >= 1 && ny >= 1 && nx <= M && ny <= N && map[ny][nx] == 1 && !visited[ny][nx]){
                                q.add(new int[]{ny, nx});
                                visited[ny][nx] = true;
                                count++;
                            }
                        }
                    }

                    if(maxCount < count) maxCount = count;
                }
            }
        }

        System.out.println(maxCount);
    }
}
