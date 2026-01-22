    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] list = new ArrayList[N + 1];
            boolean[] visited = new boolean[N + 1];
            int[] parent =  new int[N + 1];

            for(int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < N - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            Queue<Integer> q = new LinkedList<>();
            visited[1] = true;
            q.add(1);

            while(!q.isEmpty()){
                int cur =  q.poll();

                for(int x : list[cur]){
                    if(!visited[x]){
                        visited[x] = true;
                        q.add(x);
                        parent[x] = cur;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int i = 2; i <= N; i++){
                sb.append(parent[i]).append("\n");
            }

            System.out.println(sb.toString());
        }
    }
