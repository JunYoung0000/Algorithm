import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 출력 최적화용
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int current = 1; // 1부터 n까지 push할 숫자
        boolean possible = true;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // num까지 push
            while (current <= num) {
                stack.push(current);
                sb.append("+\n");
                current++;
            }

            // 스택의 top이 num과 같으면 pop
            if (stack.peek() == num) {
                stack.pop();
                sb.append("-\n");
            } else {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }
    }
}
