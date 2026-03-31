import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("-");

        int answer = 0;

        for(int i = 0; i < arr.length; i++){
            String[] str = arr[i].split("\\+");
            int num = 0;

            for(int j = 0; j < str.length; j++){
                num += Integer.parseInt(str[j]);
            }

            if(i != 0) answer -= num;
            else answer += num;
        }

        System.out.println(answer);
    }
}
