import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        boolean[][] visited = new boolean[N][M];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int ix = 0, iy = 0;

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                char ch = row.charAt(j);

                if(ch == 'I'){
                    ix = j;
                    iy = i;
                }

                map[i][j] = ch;
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{iy, ix});
        visited[iy][ix] = true;
        int count = 0;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++){
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx] && map[ny][nx] != 'X'){
                    if(map[ny][nx] == 'P'){
                        count++;
                    }

                    q.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }
            }
        }

        if(count == 0) System.out.println("TT");
        else System.out.println(count);
    }
}
