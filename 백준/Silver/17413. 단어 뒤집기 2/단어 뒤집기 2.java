import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean check = false;

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '<') {
                while (!stack.isEmpty()) sb.append(stack.pop());
                check = true;
                sb.append(ch);
            } else if (ch == '>') {
                check = false;
                sb.append(ch);
            } else if (check) {
                sb.append(ch);
            } else {
                if (ch == ' ') {
                    while (!stack.isEmpty()) sb.append(stack.pop());
                    sb.append(' ');
                } else {
                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());

        System.out.println(sb);
    }
}
