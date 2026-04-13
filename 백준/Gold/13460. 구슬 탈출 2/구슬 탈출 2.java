import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static class MoveResult {
        int x, y, dist;
        boolean isHole;

        MoveResult(int x, int y, int dist, boolean isHole) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.isHole = isHole;
        }
    }

    static MoveResult move(int x, int y, int dir) {
        int nx = x;
        int ny = y;
        int dist = 0;

        while (true) {
            int tx = nx + dx[dir];
            int ty = ny + dy[dir];

            if (board[tx][ty] == '#') break;

            nx = tx;
            ny = ty;
            dist++;

            if (board[nx][ny] == 'O') {
                return new MoveResult(nx, ny, dist, true);
            }
        }

        return new MoveResult(nx, ny, dist, false);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);

                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    board[i][j] = '.';
                } else if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                    board[i][j] = '.';
                }
            }
        }

        Queue<State> q = new LinkedList<>();
        q.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.depth >= 10) continue;

            for (int d = 0; d < 4; d++) {

                MoveResult r = move(cur.rx, cur.ry, d);
                MoveResult b = move(cur.bx, cur.by, d);

                if (b.isHole) continue;

                if (r.isHole) {
                    System.out.println(cur.depth + 1);
                    return;
                }

                int nrx = r.x;
                int nry = r.y;
                int nbx = b.x;
                int nby = b.y;

                if (nrx == nbx && nry == nby) {
                    if (r.dist > b.dist) {
                        nrx -= dx[d];
                        nry -= dy[d];
                    } else {
                        nbx -= dx[d];
                        nby -= dy[d];
                    }
                }

                if (!visited[nrx][nry][nbx][nby]) {
                    visited[nrx][nry][nbx][nby] = true;
                    q.add(new State(nrx, nry, nbx, nby, cur.depth + 1));
                }
            }
        }

        System.out.println(-1);
    }
}