class Solution {
    public int solution(String s) {
        String[] sa = s.split(" ");
        int answer = 0;
        int temp = 0;
        
        for(int i = 0; i < sa.length; i++){
            if(!sa[i].equals("Z")) {
                answer += Integer.parseInt(sa[i]);
                temp = Integer.parseInt(sa[i]);
            } else {
                answer -= temp;
            }
        }
        
        return answer;
    }
}