import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String[] strings = (br.readLine()).split(" ");
            int T = Integer.parseInt(strings[0]);

            switch(T){
                case 0:
                    sb.append(pq.isEmpty() ? "-1" : pq.poll()).append("\n");
                    break;
                default:
                    for(int m = 1; m <= T; m++){
                        pq.offer(Integer.parseInt(strings[m]));
                    }
                    break;
            }
        }

        System.out.print(sb.toString());
    }
}

