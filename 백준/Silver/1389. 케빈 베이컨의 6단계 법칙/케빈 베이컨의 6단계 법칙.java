import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            list[B].add(A);
        }

        int minPersonIndex = 1;
        int minBacon = Integer.MAX_VALUE;

        for(int j = 1; j <= N; j++){
            Queue<Integer> q = new LinkedList<>();
            int[] dist = new int[N + 1];
            Arrays.fill(dist, -1);

            int count = 1;

            q.add(j);
            dist[j] = 0;

            while(!q.isEmpty()){
                int size = q.size();

                for(int i = 0; i < size; i++){
                    int cur = q.poll();

                    for(int num : list[cur]){
                        if(dist[num] == -1){
                            q.add(num);
                            dist[num] = count;
                        }
                    }
                }

                count++;
            }

            int sum = 0;
            for (int l = 1; l <= N; l++) {
                sum += dist[l];
            }

            if (sum < minBacon) {
                minBacon = sum;
                minPersonIndex = j;
            }
        }

        System.out.println(minPersonIndex);
    }
}
