import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();   // 원본 문자열
        String bomb = br.readLine();  // 폭발 문자열
        int blen = bomb.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            stack.push(c);

            // 스택 크기가 폭발문자열 길이 이상일 때만 비교
            if (stack.size() >= blen) {
                boolean isBomb = true;

                // 스택의 끝부분이 bomb과 같은지 확인
                for (int j = 0; j < blen; j++) {
                    if (stack.get(stack.size() - blen + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                // 같으면 폭발 문자열 길이만큼 pop
                if (isBomb) {
                    for (int j = 0; j < blen; j++) {
                        stack.pop();
                    }
                }
            }
        }

        // 결과 조합
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder result = new StringBuilder();
            for (char c : stack) result.append(c);
            System.out.println(result.toString());
        }
    }
}
