import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a,b) ->{
            if(a[1] == b[1]) return a[0]-b[0];

            return a[1] - b[1];
        });

        for(int[] array : arr){
            sb.append(array[0]).append(" ").append(array[1]).append("\n");
        }

        System.out.println(sb);
    }
}