import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 1. 중복 제거
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        // 2. Set → List
        List<String> list = new ArrayList<>(set);

        // 3. 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // 길이 비교
                if (a.length() != b.length()) {
                    return a.length() - b.length();
                }
                // 사전순 비교
                return a.compareTo(b);
            }
        });

        // 4. 출력
        StringBuilder sb = new StringBuilder();
        for (String word : list) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
