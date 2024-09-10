class Solution {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        int sum = 0;
        
        for (int i = 0; i < included.length; i++){
            if(included[i] == true)
            {
                sum = a;
                for(int m= 0; m < i; m ++){
                    sum += d;
                }
                answer += sum;
            }
        }
        return answer;
    }
}