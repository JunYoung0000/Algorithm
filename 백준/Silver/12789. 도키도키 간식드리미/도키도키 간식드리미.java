import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            boolean check = true;

            while (check) {
                // ✅ 인덱스 범위 초과 방지
                if (index >= n && (stack.isEmpty() || stack.peek() != i)) {
                    System.out.println("Sad");
                    return;
                }

                if (stack.isEmpty()) {
                    if (arr[index] == i) {
                        check = false;
                        index++;
                    } else {
                        stack.push(arr[index++]);
                    }
                } else {
                    if (stack.peek() == i) {
                        check = false;
                        stack.pop();
                    } else if (index < n && arr[index] == i) {
                        check = false;
                        index++;
                    } else if (index < n) {
                        stack.push(arr[index++]);
                    } else {
                        System.out.println("Sad");
                        return;
                    }
                }
            }
        }

        System.out.println("Nice");
    }
}
