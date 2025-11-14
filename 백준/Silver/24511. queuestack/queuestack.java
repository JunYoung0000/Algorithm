import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 자료구조의 개수 N
        int N = Integer.parseInt(br.readLine());

        // A_i 배열: 0은 큐, 1은 스택
        int[] A = new int[N];
        StringTokenizer stA = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stA.nextToken());
        }

        // B_i 배열: 각 자료구조의 초기 원소
        int[] B = new int[N];
        StringTokenizer stB = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(stB.nextToken());
        }

        // Deque (양방향 큐) 생성
        // 스택은 연산에 영향을 주지 않으므로, 큐인 원소(A[i] == 0)들만 관리합니다.
        Deque<Integer> deque = new ArrayDeque<>();

        // 큐인 자료구조의 초기 원소(B[i])만 Deque에 추가합니다.
        // 예제 1에서 보듯이, 뒤쪽 큐의 원소가 먼저 pop되어야 하므로
        // 배열을 역순으로 순회하며 addLast (또는 정방향 순회하며 addFirst)를 합니다.
        // 여기서는 정방향으로 순회하며 addFirst를 사용하겠습니다.
        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                // 큐(A[i]==0)일 경우, 해당 초기 원소 B[i]를 Deque의 맨 앞에 추가
                deque.addFirst(B[i]);
            }
        }
        
        // 삽입할 수열의 길이 M
        int M = Integer.parseInt(br.readLine());

        // 삽입할 원소 C_i (배열에 저장할 필요 없이 바로 처리)
        StringTokenizer stC = new StringTokenizer(br.readLine());
        
        // 결과 출력을 위한 StringBuilder
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            // 새로 삽입할 원소
            int insertVal = Integer.parseInt(stC.nextToken());
            
            int popVal;
            
            // 만약 모든 자료구조가 스택이라 Deque가 비어있다면,
            // 입력값이 그대로 출력됩니다.
            if (deque.isEmpty()) {
                popVal = insertVal;
            } else {
                // Deque가 비어있지 않다면 (큐가 하나라도 있다면)
                // 맨 뒤(마지막 큐)에서 원소를 pop (deque의 맨 앞)
                popVal = deque.pollFirst();
                // 맨 앞(첫 번째 큐)에 새 원소를 push (deque의 맨 뒤)
                deque.addLast(insertVal);
            }
            
            // pop된 원소를 StringBuilder에 추가
            sb.append(popVal).append(" ");
        }

        // 최종 결과 출력
        System.out.println(sb.toString().trim());
    }
}