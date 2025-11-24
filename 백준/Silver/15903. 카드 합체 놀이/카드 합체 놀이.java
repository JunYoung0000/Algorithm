import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        PriorityQueue<Long> pq = new PriorityQueue<>();

        String[] stringNumbers = br.readLine().split(" ");
        for(int m = 0; m < N; m++){
            pq.offer(Long.parseLong(stringNumbers[m]));
        }

        for(int i = 0; i < M; i++){
            long num1 = pq.poll();
            long num2 = pq.poll();
            long sum = num1 + num2;

            pq.offer(sum);
            pq.offer(sum);
        }

        long answer = 0;
        while(!pq.isEmpty()){
            answer += pq.poll();
        }

        System.out.print(answer);
    }
}

