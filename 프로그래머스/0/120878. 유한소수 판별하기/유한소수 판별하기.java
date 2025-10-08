class Solution {
    public int solution(int a, int b) {
        int count = 2;
        int min = Math.min(a, b);
        
        while(count <= min){
            if(a % count == 0 && b % count == 0){
                a /= count;
                b /= count;
                count = 2;
            }
            
            count++;
        }
        
        while (b % 2 == 0) b /= 2;
        while (b % 5 == 0) b /= 5;
        
        return b == 1 ? 1 : 2;
    }
}