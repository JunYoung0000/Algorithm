import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 개행 제거

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T; i++) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");

            switch (strArr[0]) {
                case "push":
                    stack.push(Integer.parseInt(strArr[1]));
                    break;

                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.pop());
                    }
                    break;

                case "size":
                    System.out.println(stack.size());
                    break;

                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;

                case "top":
                    if (stack.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(stack.peek());
                    }
                    break;
            }
        }

        sc.close();
    }
}
