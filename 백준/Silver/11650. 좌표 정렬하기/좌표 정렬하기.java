import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();


        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

            list.add(new int[]{a, b});
        }

        list.sort((a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
           sb.append(list.get(i)[0]).append(" ").append(list.get(i)[1]).append("\n");
        }

        System.out.println(sb.toString());
    }
}

