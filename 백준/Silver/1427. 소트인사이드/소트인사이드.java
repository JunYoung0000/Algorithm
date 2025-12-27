import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input =  br.readLine();
        int size = input.length();
        int[] arr = new int[size];

        for(int i=0;i<size;i++){
            arr[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i=size-1;i>=0;i--){
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}