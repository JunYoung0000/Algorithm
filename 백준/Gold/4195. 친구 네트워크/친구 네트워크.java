import java.io.*;
import java.util.*;

public class Main {

    // Union-Find (Disjoint Set)
    static class UnionFind {
        int[] parent; // 부모(대표)
        int[] size;   // 네트워크 인원 수

        UnionFind(int n) {
            parent = new int[n];
            size = new int[n];

            // 처음엔 모두 자기 자신이 대표, 크기는 1
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // 대표 찾기 (경로 압축)
        int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]);
        }

        // 두 집합 합치기
        int union(int a, int b) {
            a = find(a);
            b = find(b);

            // 이미 같은 네트워크면 그대로 크기 반환
            if (a == b) return size[a];

            // b를 a에 붙임
            parent[b] = a;
            size[a] += size[b];

            // 합쳐진 네트워크 크기 반환
            return size[a];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine()); // 친구 관계 수

            // 이름 → 숫자 ID 매핑
            HashMap<String, Integer> map = new HashMap<>();

            // 최대 인원 수 = 친구 관계 * 2
            UnionFind uf = new UnionFind(F * 2);

            int idx = 0; // 새로운 사람에게 줄 ID

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name1 = st.nextToken();
                String name2 = st.nextToken();

                // 처음 나온 이름이면 ID 부여
                if (!map.containsKey(name1)) {
                    map.put(name1, idx++);
                }
                if (!map.containsKey(name2)) {
                    map.put(name2, idx++);
                }

                // 두 사람의 네트워크 합치고 결과 출력
                int result = uf.union(map.get(name1), map.get(name2));
                sb.append(result).append('\n');
            }
        }

        System.out.print(sb);
    }
}
