    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            StringBuilder sb = new StringBuilder();

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for(int t = 0; t < T; t++ ) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int M = Integer.parseInt(st.nextToken());
                int N = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());


                int[][] map = new int[M][N];
                boolean[][] visited = new boolean[M][N];

                for(int k = 0; k < K; k++) {
                    StringTokenizer st2 = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st2.nextToken());
                    int b = Integer.parseInt(st2.nextToken());

                    map[a][b] = 1;
                }

                Queue<int[]> q = new LinkedList<>();

                int count = 0;

                for(int i = 0; i < M; i++) {
                    for(int j = 0; j < N; j++) {
                        if(!visited[i][j] && map[i][j] == 1) {
                            q.add(new int[]{i, j});
                            visited[i][j] = true;
                            count++;


                            while(!q.isEmpty()) {
                                int[] cur = q.poll();

                                for (int d = 0; d < 4; d++) {
                                    int nx = cur[0] + dx[d];
                                    int ny = cur[1] + dy[d];

                                    if(nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {
                                        q.add(new int[]{nx, ny});
                                        visited[nx][ny] = true;
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