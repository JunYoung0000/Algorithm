import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> q = new LinkedList<>();
        int count = 0;
        int maxArea = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int area = 0;

                if(!visited[i][j] && map[i][j] == 1){
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    count++;
                }

                while(!q.isEmpty()){
                    int[] cur = q.poll();
                    area++;

                    for(int d = 0; d < 4; d++){
                        int nx = cur[1] + dx[d];
                        int ny = cur[0] + dy[d];

                        if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[ny][nx] && map[ny][nx] == 1){
                            q.add(new int[]{ny, nx});
                            visited[ny][nx] = true;
                        }
                    }
                }


                if(maxArea < area) maxArea = area;
            }
        }

        System.out.println(count);
        System.out.println(maxArea);



    }
}