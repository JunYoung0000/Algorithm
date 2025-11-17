import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int T = Integer.parseInt(arr[0]);
        int N = Integer.parseInt(arr[1]);
        Queue<Integer> q = new LinkedList<>();
        
        StringBuilder sb = new StringBuilder();

        sb.append("<");
        
        for(int i = 1; i <= T; i++){
            q.offer(i);
        }

        for(int i = 1; i <= T; i++){
            for(int m = 0; m < N - 1; m++){
                q.offer(q.poll());
            }
            
            sb.append(q.poll());
            
            if(i != T) sb.append(", ");
        }
        
        sb.append(">");
        System.out.println(sb.toString());
    }
}
