import java.io.*;

public class Main {

    static int N;
    static int[] col;
    static int count = 0;

    static void backtrack(int row) {
        if (row == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            col[row] = i;

            if (isPossible(row)) {
                backtrack(row + 1);
            }
        }
    }

    static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {

            if (col[row] == col[i]) return false;

            if (Math.abs(col[row] - col[i]) == Math.abs(row - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new int[N];
        backtrack(0);

        System.out.println(count);
    }
}