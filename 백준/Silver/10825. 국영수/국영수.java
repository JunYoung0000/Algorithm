import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N =  Integer.parseInt(br.readLine());

        String[][] str = new String[N][4];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            str[i][0] = st.nextToken();
            str[i][1] = st.nextToken();
            str[i][2] = st.nextToken();
            str[i][3] = st.nextToken();
        }

        List<String[]> list = new ArrayList<>(Arrays.asList(str));

        Collections.sort(list, (a, b) -> {
            if (Integer.parseInt(a[1]) != Integer.parseInt(b[1]))
                return Integer.parseInt(b[1]) - Integer.parseInt(a[1]);

            if (Integer.parseInt(a[2]) != Integer.parseInt(b[2]))
                return Integer.parseInt(a[2]) - Integer.parseInt(b[2]);

            if (Integer.parseInt(a[3]) != Integer.parseInt(b[3]))
                return Integer.parseInt(b[3]) - Integer.parseInt(a[3]);

            return a[0].compareTo(b[0]);
        });

        StringBuilder sb = new StringBuilder();
        for(String[] arr : list){
            sb.append(arr[0]).append("\n");
        }

        System.out.println(sb);
    }
}