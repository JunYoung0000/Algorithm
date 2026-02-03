import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] list;
    static int[] hackCount;
    static int[] visited;
    static int visitToken = 0; // 방문 체크용 토큰

    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // B를 해킹하면 A도 해킹되므로, B -> A 방향으로 저장
            list[B].add(A);
        }

        hackCount = new int[N + 1];
        visited = new int[N + 1];
        int maxComputer = 0;

        for (int i = 1; i <= N; i++) {
            visitToken++; // 매 반복마다 새로운 토큰 사용 (초기화 대신)
            hackCount[i] = bfs(i);
            if (hackCount[i] > maxComputer) {
                maxComputer = hackCount[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (hackCount[i] == maxComputer) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>(); // LinkedList보다 ArrayDeque가 빠름
        q.add(start);
        visited[start] = visitToken;
        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int next : list[cur]) {
                if (visited[next] != visitToken) {
                    visited[next] = visitToken;
                    q.add(next);
                }
            }
        }
        return count;
    }
}