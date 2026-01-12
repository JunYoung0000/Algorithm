import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long[] answer = new long[2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;

        long a = 0, b = 0;
        long min = Long.MAX_VALUE;

        while(left < right){
            long sum = arr[left] + arr[right];

            if(Math.abs(sum) < min){
                a =  arr[left];
                b = arr[right];

                min = Math.abs(sum);
            }

            if(sum > 0) right--;
            else left++;
        }

        System.out.println(a + " " + b);
    }
}