import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        List<Integer> resultList = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(X);
        dist[X] = 0;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int num : list[cur]){
                if(dist[num] == -1) {
                    dist[num] = dist[cur] + 1;
                    q.add(num);
                }
            }
        }

        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(dist[i] == K){
                sb.append(i).append("\n");
                flag = true;
            }
        }

        if(flag) System.out.println(sb);
        else System.out.println(-1);
    }
}