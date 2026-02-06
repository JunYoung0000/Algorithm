import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        List<int[]> list = new ArrayList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int T = Integer.parseInt(st.nextToken());

                if(T == 1) {
                    list.add(new int[]{i, j});
                }

                map[i][j] = T;
            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < list.size(); i++){
            int[] temp = list.get(i);
            q.add(temp);
        }

        int count = 0;


        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;

            for(int i = 0; i < size; i++){
                int[] cur = q.poll();
                int x = cur[1];
                int y = cur[0];

                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx >= 0 && ny >= 0 && nx < M && ny < N && map[ny][nx] == 0){
                        q.add(new int[]{ny, nx});
                        map[ny][nx] = 1;
                        flag = true;
                    }
                }
            }

            if(flag) count++;
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j< M; j++){
                if(map[i][j] == 0) count = -1;
            }
        }

        System.out.println(count);
    }
}
