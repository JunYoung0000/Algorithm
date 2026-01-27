import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[n + 1];
        boolean[] visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        Queue<Integer> q = new LinkedList<>();

        int count = 0;
        boolean flag = false;

        q.add(a);
        visited[a] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int j = 0; j < size; j++){
                int cur = q.poll();

                for(int i : list[cur]) {
                    if(!visited[i] && i != b) {
                        q.add(i);
                        visited[i] = true;
                    }

                    if(i == b){
                        flag = true;
                        break;
                    }
                }

                if(flag) break;
            }

            count++;

            if(flag) break;
        }

        if(flag) System.out.println(count);
        else System.out.println(-1);
    }
}
