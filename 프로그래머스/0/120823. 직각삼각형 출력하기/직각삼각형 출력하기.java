import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for(int i = 1; i <= n; i++){
            for(int m = 0; m < i; m++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}