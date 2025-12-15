import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> countMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;

            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(countMap.keySet());

        words.sort((a, b) -> {
            // 1. 빈도수 내림차순
            int freqCompare = countMap.get(b) - countMap.get(a);
            if (freqCompare != 0) return freqCompare;

            // 2. 길이 내림차순
            int lengthCompare = b.length() - a.length();
            if (lengthCompare != 0) return lengthCompare;

            // 3. 사전순 오름차순
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append('\n');
        }

        System.out.print(sb);
    }
}
