import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int count = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int houseCount;

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    houseCount=0;
                    dfs(i, j);
                    list.add(houseCount);
                    count++;
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for(int num : list){
            System.out.println(num);
        }
    }

    static void dfs(int i, int j) {
        visited[i][j] = true;
        houseCount++;

        for (int d = 0; d < 4; d++) {
            int x = j + dx[d];
            int y = i + dy[d];

            if (x >= 0 && y >= 0 && x < N && y < N ) {
                if(!visited[y][x] && map[y][x] == 1) {
                    dfs(y, x);
                }
            }
        }
    }
}
