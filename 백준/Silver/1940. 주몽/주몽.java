import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 정렬
        Arrays.sort(arr);

        // 2. 투 포인터
        int i = 0;
        int j = N - 1;
        int count = 0;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum == M) {
                count++;
                i++;
                j--;
            } else if (sum < M) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println(count);
    }
}
