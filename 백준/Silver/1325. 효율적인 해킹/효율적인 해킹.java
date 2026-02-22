import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int maxHackedComputerCount = 0, hackedComputerCount;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];


        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph[B].add(A);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            visited = new boolean[n + 1];
            hackedComputerCount = 0;
            dfs(i);

            if (hackedComputerCount > maxHackedComputerCount) {
                maxHackedComputerCount = hackedComputerCount;
                list.clear();
                list.add(i);
            } else if (hackedComputerCount == maxHackedComputerCount) {
                list.add(i);
            }
        }

        Collections.sort(list);

        for(int num: list){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int num) {
        visited[num] = true;
        hackedComputerCount++;

        for(int next: graph[num]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
