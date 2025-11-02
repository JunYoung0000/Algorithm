import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n];
        int[] result = new int[n];
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            height[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int h = height[i];

            while(!stack.isEmpty() && stack.peek()[0] <= h){
                stack.pop();
            }

            if(stack.isEmpty()) result[i] = 0;
            else result[i] = stack.peek()[1];

            stack.push(new int[]{h, i+1});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(result[i]).append(' ');
        System.out.println(sb);
    }
}