import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1){
            System.out.println(0);
            return;
        }

        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N - 1; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int min = 0;

        while(pq.peek() >= T){
            pq.offer(pq.poll() - 1);
            T++;
            min++;
        }

        System.out.print(min);
    }
}

