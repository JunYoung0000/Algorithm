import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M  = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        boolean[][] visited = new boolean[M][N];

        for(int i = 0; i < K; i++){
            st = new  StringTokenizer(br.readLine());
            int x1 =  Integer.parseInt(st.nextToken());
            int y1 =  Integer.parseInt(st.nextToken());
            int x2 =  Integer.parseInt(st.nextToken());
            int y2 =  Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++){
                for(int l = y1; l < y2; l++){
                    map[l][j] = 1;
                    visited[l][j] = true;
                }
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && map[i][j] == 0){
                    int area = 0;

                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] cur = q.poll();
                        area++;

                        for(int k = 0; k < 4; k++){
                            int y = cur[0] + dy[k];
                            int x = cur[1] + dx[k];

                            if(x >= 0 && y >= 0 && x < N && y < M && !visited[y][x] && map[y][x] == 0){
                                q.add(new int[]{y, x});
                                visited[y][x] = true;
                            }
                        }
                    }

                    list.add(area);
                }
            }
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();

        System.out.println(list.size());
        for(int num : list){
            sb.append(num).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
