import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int K = Integer.parseInt(strings[1]);

        int[][] jewel = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            jewel[i][0] = Integer.parseInt(input[0]); // M: 무게
            jewel[i][1] = Integer.parseInt(input[1]); // V: 가격
        }

        int[] kWeight = new int[K];
        for(int i = 0; i < K; i++){
            kWeight[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, (a, b) -> a[0] - b[0]);
        Arrays.sort(kWeight);

        int idx = 0;
        long answer = 0;
        for(int c : kWeight){
            while(idx < N && jewel[idx][0] <= c) {
                pq.offer(jewel[idx][1]);
                idx++;
            }

            if(!pq.isEmpty()){
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
