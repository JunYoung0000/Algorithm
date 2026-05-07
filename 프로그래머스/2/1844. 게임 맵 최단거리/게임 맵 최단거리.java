import java.util.*;

class Solution {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {

        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (maps[nx][ny] == 0) {
                    continue;
                }

                if (maps[nx][ny] == 1) {

                    maps[nx][ny] = maps[current.x][current.y] + 1;

                    queue.offer(new Node(nx, ny));
                }
            }
        }

        if (maps[n - 1][m - 1] == 1) {
            return -1;
        }

        return maps[n - 1][m - 1];
    }
}