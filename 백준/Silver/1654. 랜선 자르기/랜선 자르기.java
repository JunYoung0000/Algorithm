import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        int MAX = Integer.MIN_VALUE;

        for(int i = 0; i < K; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;

            if(MAX < num) MAX = num;
        }

        long left = 1;
        long right = MAX;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            long sum = 0;

            for(int num : arr){
                sum += num / mid;
            }

            if(sum >= N){
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}

