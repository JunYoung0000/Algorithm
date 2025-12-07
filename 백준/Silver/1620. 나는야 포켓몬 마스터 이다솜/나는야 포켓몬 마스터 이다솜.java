import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> nameToNum = new HashMap<>();
        HashMap<Integer, String> numToName = new HashMap<>();

        // N개의 포켓몬 입력
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNum.put(name, i);
            numToName.put(i, name);
        }

        // M개의 문제 처리
        for (int i = 0; i < M; i++) {
            String q = br.readLine();

            // 숫자인지 확인
            if (Character.isDigit(q.charAt(0))) {
                int num = Integer.parseInt(q);
                sb.append(numToName.get(num)).append('\n');
            } else {
                sb.append(nameToNum.get(q)).append('\n');
            }
        }

        System.out.print(sb);
    }
}
