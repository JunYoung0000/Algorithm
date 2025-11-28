import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            // 1. 일단 maxHeap에 넣기
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // 2. size 조정 (maxHeap이 항상 크거나 같아야 함)
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }

            // 3. 중간값 출력 = maxHeap의 루트
            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
