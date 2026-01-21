    import java.io.*;
    import java.util.*;

    public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[N + 1];
            boolean[] visited = new boolean[N + 1];

            for(int i = 1; i <= N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 1; i <= M; i++){
                st = new StringTokenizer(br.readLine());

                int u =  Integer.parseInt(st.nextToken());
                int v =  Integer.parseInt(st.nextToken());

                list[u].add(v);
                list[v].add(u);
            }

            int count = 0;

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    visited[i] = true;

                    while (!q.isEmpty()) {
                        int cur = q.poll();

                        for (int next : list[cur]) {
                            if (!visited[next]) {
                                visited[next] = true;
                                q.add(next);
                            }
                        }
                    }

                    count++;
                }
            }

            System.out.println(count);
        }
    }
