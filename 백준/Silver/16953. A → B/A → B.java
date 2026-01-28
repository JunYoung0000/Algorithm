import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<Long> q = new LinkedList<>();

        q.add(A);
        int count = 0;
        boolean flag = false;

        while(!q.isEmpty()) {
            int size = q.size();
            count++;

            for(int i = 0; i < size; i++) {
                long x = q.poll();

                if(x==B){
                    flag = true;
                    break;
                }

                if(2*x >= 1 && 2*x <= 1000000000){
                    q.add(2 * x);
                }

                if(10*x + 1 >= 1 && 10*x + 1 <= 1000000000){
                    q.add(10*x + 1);
                }
            }

            if(flag) break;
        }

        if(flag) System.out.println(count);
        else System.out.println(-1);

    }
}
