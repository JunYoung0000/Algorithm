import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0; i < N; i++) {
            String line =  br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int count = 1;

                    while(!q.isEmpty()) {
                        int[] cur = q.poll();

                        for (int d = 0; d < 4; d++) {
                            int nx = cur[0] + dx[d];
                            int ny = cur[1] + dy[d];

                            if(nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                                q.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                count++;
                            }
                        }
                    }

                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());

        for(int num : list) {
            System.out.println(num);
        }
    }
}