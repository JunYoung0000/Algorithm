    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int time = 0;

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[100001];

            q.add(N);
            visited[N] = true;

            boolean flag = true;

            while(flag){
                int size = q.size();

                for(int i = 0; i < size; i++){
                    int x = q.poll();

                    if(x == K){
                        flag = false;
                        System.out.println(time);
                        break;
                    }

                    if(x-1 >= 0 && x-1 <= 100000 && !visited[x-1]) {
                        q.add(x - 1);
                        visited[x-1] = true;
                    }

                    if(x+1 >= 0 && x+1 <= 100000 &&!visited[x+1]) {
                        q.add(x+1);
                        visited[x+1] = true;
                    }

                    if(x*2 >= 0 && x*2 <= 100000 &&!visited[x*2]) {
                        q.add(2*x);
                        visited[x*2] = true;
                    }
                }

                time++;
            }
        }
    }
