import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int answer = 0;

        Stack<Character> stack = new Stack<>();
        char[] arr = input.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') {
                stack.push('(');
            } else if (arr[i] == ')') {
                stack.pop();
                if (arr[i - 1] == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        sc.close();
    }
}





