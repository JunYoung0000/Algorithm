import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < N; i++){
            String[] str = br.readLine().split(" ");

            switch (str[0]){
                case "push":
                    q.offer(Integer.parseInt(str[1]));
                    break;
                case "front":
                    if(!q.isEmpty()) {
                        sb.append(q.peek());
                        sb.append("\n");
                    }
                    else sb.append("-1\n");
                    break;
                case "back":
                    if (!q.isEmpty()) sb.append(((LinkedList<Integer>) q).getLast()).append("\n");
                    else sb.append("-1\n");
                    break;
                case "size":
                    sb.append(q.size());
                    sb.append("\n");
                    break;
                case "pop":
                    if(!q.isEmpty()){
                        sb.append(q.poll());
                        sb.append("\n");
                    }
                    else sb.append("-1\n");
                    break;
                case "empty":
                    if(!q.isEmpty()) sb.append("0 \n");
                    else sb.append("1\n");
                    break;
                default:
                    break;
            }

        }

        System.out.println(sb.toString());
    }
}
