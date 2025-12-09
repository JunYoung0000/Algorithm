import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) set.add(name);
            else set.remove(name);
        }

        List<String> list = new ArrayList<>(set);
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (String name : list) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);
    }
}