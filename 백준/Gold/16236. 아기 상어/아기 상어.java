import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int eatCount = 0;
    static int time = 0;

    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    static class Fish implements Comparable<Fish> {
        int y, x, dist;

        Fish(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }

        public int compareTo(Fish o) {
            if (this.dist != o.dist) return this.dist - o.dist;
            if (this.y != o.y) return this.y - o.y;
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        int sharkY = 0, sharkX = 0;

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
                if (map[y][x] == 9) {
                    sharkY = y;
                    sharkX = x;
                    map[y][x] = 0;
                }
            }
        }

        while (true) {
            Fish target = bfs(sharkY, sharkX);
            if (target == null) break;

            time += target.dist;
            sharkY = target.y;
            sharkX = target.x;

            map[sharkY][sharkX] = 0;
            eatCount++;

            if(eatCount == sharkSize){
                sharkSize++;
                eatCount = 0;
            }
        }

        System.out.println(time);
    }

    static Fish bfs(int startY, int startX){
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<>();
        List<Fish> fishes = new ArrayList<>();

        q.add(new int []{startY, startX, 0});
        visited[startY][startX] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];
            int dist = now[2];

            for(int d = 0; d < 4; d++){
                int ny = y + dy[d];
                int nx = x + dx[d];

                if(ny < 0 || nx < 0 || ny >= N || nx >= N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx] > sharkSize) continue;

                visited[ny][nx] = true;
                if(map[ny][nx] != 0 && map[ny][nx] < sharkSize){
                    fishes.add(new Fish(ny, nx, dist+1));
                }

                q.add(new int[]{ny, nx, dist + 1});
            }
        }

        if(fishes.isEmpty()) return null;

        Collections.sort(fishes);
        return fishes.get(0);
    }
}
