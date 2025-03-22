class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] ex = binomial.split(" ");
        int a = Integer.parseInt(ex[0]);
        int b = Integer.parseInt(ex[2]);
        String operation = ex[1];
        
        switch(operation){
            case "+":
                answer = a + b;
                break;
            case "-":
                answer = a - b;
                break;
            case "*":
                answer = a * b;
                break;
        }
        return answer;
    }
}