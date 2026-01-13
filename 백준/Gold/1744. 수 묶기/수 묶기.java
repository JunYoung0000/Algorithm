import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;

        for(int i = 0; i + 1 < N; i += 2){
            if(arr[i] <= 0 && arr[i+1] <= 0){
                answer += arr[i] * arr[i+1];
                left = i+2;
            } else break;
        }

        for(int i = N - 1; i - 1 >= left; i -= 2){
            if(arr[i] > 1 && arr[i-1] > 1){
                answer += arr[i] * arr[i-1];
                right = i-2;
            } else break;
        }

        while(left <= right){
            answer += arr[right];
            right--;
        }

        System.out.println(answer);
    }
}