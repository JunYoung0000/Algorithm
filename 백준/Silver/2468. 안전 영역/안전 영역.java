    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            int[][] map =  new int[N][N];


            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};


            int max = 0;

            for(int h = 0; h <= 100; h++){
                int count = 0;
                boolean[][] visited = new boolean[N][N];
                
                Queue<int[]> q = new LinkedList<>();

                for(int i = 0; i < N; i++){
                    for(int j = 0; j < N; j++){
                        if(!visited[i][j] && map[i][j] > h){
                            q.add(new int[] {i, j});
                            visited[i][j] = true;
                            count++;
                        }


                        while(!q.isEmpty()){
                            int[] cur = q.poll();

                            for(int d = 0; d < 4; d++){
                                int x = cur[0] + dx[d];
                                int y = cur[1] + dy[d];


                                if(x >= 0 && y >= 0 && x < N && y < N && !visited[x][y] && map[x][y] > h){
                                    q.add(new int[] {x, y});
                                    visited[x][y] = true;
                                }
                            }
                        }
                    }
                }

                if(count > max) max = count;
            }

            System.out.println(max);
        }
    }
