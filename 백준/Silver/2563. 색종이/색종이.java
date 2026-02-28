import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] map = new boolean[100][100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = y; j < y + 10; j++) {
                for (int k = x; k < x + 10; k++) {
                    if (j >= 0 && j < 100 && k >= 0 && k < 100) {
                        if (!map[j][k]) {
                            map[j][k] = true;
                        }
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j]) count++;
            }
        }

        System.out.println(count);
    }
}
