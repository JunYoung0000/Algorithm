import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "push_back":
                    dq.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(!dq.isEmpty()){
                        System.out.println(dq.pollFirst());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "pop_back":
                    if(!dq.isEmpty()){
                        System.out.println(dq.pollLast());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "front":
                    if(!dq.isEmpty()){
                        System.out.println(dq.peekFirst());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "back":
                    if(!dq.isEmpty()){
                        System.out.println(dq.peekLast());
                    } else {
                        System.out.println("-1");
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(!dq.isEmpty()){
                        System.out.println("0");
                    } else {
                        System.out.println("1");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
