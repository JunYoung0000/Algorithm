import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expr = br.readLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expr.toCharArray()) {
            // 1. 피연산자 (A~Z)
            if (Character.isAlphabetic(ch)) {
                result.append(ch);
            }
            // 2. '(' 는 스택에 push
            else if (ch == '(') {
                stack.push(ch);
            }
            // 3. ')' 는 '(' 나올 때까지 pop
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // '(' 제거
            }
            // 4. 연산자 (+, -, *, /)
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // 남은 연산자 전부 pop
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        System.out.println(result);
    }

    // 연산자 우선순위 반환
    private static int precedence(char op) {
        if (op == '(') return 0;
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return -1;
    }
}
