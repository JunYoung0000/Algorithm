import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < N; i++) {
            String input = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (char ch : input.toCharArray()) {
                switch (ch) {
                    case '<':
                        if (!left.isEmpty())
                            right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty())
                            left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty())
                            left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }

            // 왼쪽 스택 -> 오른쪽 스택으로 옮기면 순서가 뒤집힘
            while (!left.isEmpty())
                right.push(left.pop());

            // 오른쪽 스택에서 빼면 최종 비밀번호 완성
            while (!right.isEmpty())
                sb.append(right.pop());
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
