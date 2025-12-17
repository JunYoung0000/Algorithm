import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            if(str.equals("ENTER")){
                set = new HashSet<>();
            } else {
                if (!set.contains(str)) {
                    count++;
                    set.add(str);
                }
            }
        }

        System.out.println(count);
    }
}
