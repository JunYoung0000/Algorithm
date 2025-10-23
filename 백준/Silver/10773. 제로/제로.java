import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < T; i++) {
            String str = sc.nextLine();
            if(str.equals("0")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(str));
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);

        sc.close();
    }
}

