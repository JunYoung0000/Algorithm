import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[] S = new boolean[21];
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {
                case "add":
                    int add = Integer.parseInt(st.nextToken());
                    S[add] = true;
                    break;
                case "remove":
                    int remove = Integer.parseInt(st.nextToken());
                    S[remove] = false;
                    break;
                case "check":
                    if (S[Integer.parseInt(st.nextToken())])
                        sb.append("1\n");
                    else
                        sb.append("0\n");
                    break;
                case "toggle":
                    int num = Integer.parseInt(st.nextToken());
                    if (S[num]) S[num] = false;
                    else S[num] = true;
                    break;
                case "all":
                    for (int j = 1; j <= 20; j++) {
                        S[j] = true;
                    }
                    break;
                case "empty":
                    for (int j = 1; j <= 20; j++) {
                        S[j] = false;
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}
