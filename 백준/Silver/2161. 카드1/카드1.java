import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        while(!q.isEmpty()){
            sb.append(q.poll());
            sb.append(" ");
            if(!q.isEmpty()) q.offer(q.poll());
        }

        System.out.println(sb.toString());
    }
}
