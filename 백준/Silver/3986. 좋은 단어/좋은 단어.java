import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int goodCount = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine().trim();
            char[] stack = new char[s.length()];
            int top = 0; // 다음에 넣을 위치 (스택 크기)

            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (top > 0 && stack[top - 1] == c) {
                    top--; // 짝이므로 pop
                } else {
                    stack[top++] = c; // push
                }
            }

            if (top == 0) goodCount++;
        }

        System.out.println(goodCount);
    }
}
