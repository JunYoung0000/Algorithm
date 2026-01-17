import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M =  Integer.parseInt(br.readLine());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        boolean[] visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        q.add(1);
        visited[1] = true;
        int count = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next : list[cur]){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}