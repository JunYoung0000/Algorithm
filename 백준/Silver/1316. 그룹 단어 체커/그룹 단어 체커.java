import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++) {
            String input =  br.readLine();
            char prevCh = input.charAt(0);
            HashSet<Character> set = new HashSet<>();
            set.add(prevCh);
            boolean flag = true;

            for(int j = 1; j < input.length(); j++){
                char ch = input.charAt(j);

                if(prevCh != ch){
                    if(set.contains(ch)){
                        flag = false;
                        break;
                    } else {
                        set.add(ch);
                        prevCh = ch;
                    }
                }
            }
            if(flag) count++;
        }

        System.out.println(count);
    }
}
