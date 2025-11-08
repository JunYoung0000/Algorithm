import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt(); // 사람 수
        int K = sc.nextInt(); // 제거할 순서
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 1부터 N까지 큐에 추가
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        // 큐가 빌 때까지 반복
        while (!queue.isEmpty()) {
            // K-1번째까지는 맨 앞을 뒤로 보냄
            for (int i = 0; i < K - 1; i++) {
                queue.add(queue.poll());
            }
            // K번째는 제거
            sb.append(queue.poll());
            
            // 마지막이 아니면 ", " 추가
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }
        
        sb.append(">");
        System.out.println(sb);
    }
}
