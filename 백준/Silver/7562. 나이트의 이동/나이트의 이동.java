import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            int I = Integer.parseInt(br.readLine());

            boolean[][] visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();

            if(x1 != x2 || y1 != y2) q.add(new int[]{x1, y1});
            visited[x1][y1] = true;
            int count = 0;

            while(!q.isEmpty()){
                boolean flag = false;
                int size = q.size();

                for(int j = 0; j < size; j++){
                    int[] cur = q.poll();

                    for(int d = 0; d < 8; d++){
                        int nx = cur[0] + dx[d];
                        int ny = cur[1] + dy[d];

                        if(nx >= 0 && ny >= 0 && nx < I && ny < I && !visited[nx][ny]){
                            if(nx == x2 && ny == y2){
                                flag = true;
                                break;
                            }

                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }

                    if(flag) break;
                }

                count++;

                if(flag) break;
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}