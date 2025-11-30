import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        int id;

        Node(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.value, b.value));
            PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.value, a.value));

            boolean[] visited = new boolean[k];
            int inputIdx = 0;

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    Node node = new Node(num, inputIdx);
                    minHeap.offer(node);
                    maxHeap.offer(node);
                    visited[inputIdx] = true;
                    inputIdx++;
                } else {
                    if (num == 1) {
                        while (!maxHeap.isEmpty() && !visited[maxHeap.peek().id]) {
                            maxHeap.poll();
                        }
                        if (!maxHeap.isEmpty()) {
                            visited[maxHeap.peek().id] = false;
                            maxHeap.poll();
                        }
                    } else {
                        while (!minHeap.isEmpty() && !visited[minHeap.peek().id]) {
                            minHeap.poll();
                        }
                        if (!minHeap.isEmpty()) {
                            visited[minHeap.peek().id] = false;
                            minHeap.poll();
                        }
                    }
                }
            }

            while (!minHeap.isEmpty() && !visited[minHeap.peek().id]) {
                minHeap.poll();
            }
            while (!maxHeap.isEmpty() && !visited[maxHeap.peek().id]) {
                maxHeap.poll();
            }

            if (minHeap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(maxHeap.peek().value).append(" ").append(minHeap.peek().value).append("\n");
            }
        }

        System.out.print(sb);
    }
}