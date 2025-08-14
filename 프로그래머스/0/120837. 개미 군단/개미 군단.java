class Solution {
    public int solution(int hp) {
        int answer = hp >= 5 ? hp / 5 : 0;
        int temp = hp >= 5 ? hp % 5 : hp;
        
        if(temp >= 3 && temp < 5){
            answer += (temp / 3);
            temp %= 3;
        }
        if(temp > 0 && temp < 3){
            answer += temp;
        }
        
        return answer;
    }
}