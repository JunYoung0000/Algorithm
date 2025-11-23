import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int topK = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < topK; i++){
            String[] strings = br.readLine().split(" ");
            for(int m = 0; m < strings.length; m++){
                if(pq.size() < topK) pq.offer(Integer.parseInt(strings[m]));
                else if (pq.peek() < Integer.parseInt(strings[m])){
                    pq.poll();
                    pq.offer(Integer.parseInt(strings[m]));
                }
            }
        }
        System.out.print(pq.peek());
    }
}

