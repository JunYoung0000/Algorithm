import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");

            switch(input[0]){
                case "push":
                    q.offer(Integer.parseInt(input[1]));
                    break;
                case "front":
                    if(!q.isEmpty()) System.out.println(q.peek());
                    else System.out.println(-1);
                    break;
                case "back":
                    if(!q.isEmpty()) System.out.println(((LinkedList<Integer>) q).peekLast());
                    else System.out.println(-1);
                    break;
                case "empty":
                    if(!q.isEmpty()) System.out.println(0);
                    else System.out.println(1);
                    break;
                case "pop":
                    if(!q.isEmpty()) System.out.println(q.poll());
                    else System.out.println(-1);
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                default: break;
            }
        }
    }
}
