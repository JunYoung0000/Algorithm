import java.io.*;
import java.util.*;

public class Main {
    static class Applicant {
        int doc, interview;

        Applicant(int doc, int interview) {
            this.doc = doc;
            this.interview = interview;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            Applicant[] arr = new Applicant[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                arr[i] = new Applicant(doc, interview);
            }

            // 서류 성적 기준 오름차순 정렬
            Arrays.sort(arr, (a, b) -> a.doc - b.doc);

            int count = 0;
            int minInterview = Integer.MAX_VALUE;

            for (Applicant a : arr) {
                if (a.interview < minInterview) {
                    count++;
                    minInterview = a.interview;
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
