import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int F =  Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] floor =  new boolean[F + 1];

        Queue<Integer> q = new LinkedList<>();

        q.add(S);
        floor[S] = true;
        int button = 0;
        boolean flag = false;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int cur = q.poll();
                if(cur == G){
                    flag = true;
                    break;
                }

                int curU = cur + U;
                int curD = cur - D;

                if(curU <= F && curU >= 1 && !floor[curU]){
                    q.add(curU);
                    floor[curU] = true;
                }

                if(curD <= F && curD >= 1 && !floor[curD]){
                    q.add(curD);
                    floor[curD] = true;
                }
            }

            if(flag) break;
            else button++;
        }

        if(flag) System.out.println(button);
        else System.out.println("use the stairs");
    }
}
