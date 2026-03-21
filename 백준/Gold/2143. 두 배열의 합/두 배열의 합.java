import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1️⃣ 부분 배열 합 만들기
        List<Long> sumA = new ArrayList<>();
        List<Long> sumB = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        for (int i = 0; i < m; i++) {
            long sum = 0;
            for (int j = i; j < m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        // 2️⃣ 정렬
        Collections.sort(sumA);
        Collections.sort(sumB);

        // 3️⃣ 투포인터
        int left = 0;
        int right = sumB.size() - 1;
        long answer = 0;

        while (left < sumA.size() && right >= 0) {
            long a = sumA.get(left);
            long b = sumB.get(right);
            long sum = a + b;

            if (sum == T) {
                long cntA = 0;
                long cntB = 0;

                // A에서 같은 값 개수
                while (left < sumA.size() && sumA.get(left) == a) {
                    cntA++;
                    left++;
                }

                // B에서 같은 값 개수
                while (right >= 0 && sumB.get(right) == b) {
                    cntB++;
                    right--;
                }

                answer += cntA * cntB;

            } else if (sum < T) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(answer);
    }
}