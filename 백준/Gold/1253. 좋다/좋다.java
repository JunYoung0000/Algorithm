import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for(int i = 0; i < N; i++){
            int left = 0;
            int right = N - 1;

            while(left < right){
                long target = arr[i];

                if(left == i){
                    left++;
                    continue;
                }

                if(right == i){
                    right--;
                    continue;
                }

                long sum = arr[left] + arr[right];
                if(sum == target){
                    answer++;
                    break;
                } else if (sum < target){
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(answer);
    }
}