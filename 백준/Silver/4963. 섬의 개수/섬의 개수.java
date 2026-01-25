import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0) break;

            int[][] map = new int[h][w];
            boolean[][] visited = new boolean[h][w];

            for(int i = 0; i < h; i++){
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < w; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Queue<int[]> q = new LinkedList<>();
            int count = 0;

            for(int i = 0; i < h; i++){
                for(int j = 0; j < w; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        q.add(new int[]{i, j});
                        visited[i][j] = true;
                        count++;

                        while(!q.isEmpty()){
                            int[] cur = q.poll();

                            for(int d = 0; d < 8; d++){
                                int nx = cur[1] + dx[d];
                                int ny = cur[0] + dy[d];

                                if(nx >= 0 && ny >= 0 && nx < w && ny < h && !visited[ny][nx] && map[ny][nx] == 1){
                                    q.add(new int[]{ny, nx});
                                    visited[ny][nx] = true;
                                }
                            }
                        }
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
