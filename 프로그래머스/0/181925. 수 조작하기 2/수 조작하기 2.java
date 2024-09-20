class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
            
        for(int i = 0; i < numLog.length -1; i++){
            int i1 = numLog[i];
            int i2 = numLog[i+1];
            int value = i2 - i1;
            
            if(value == 1){
                sb.append("w");
            }
            else if(value == -1){
                sb.append("s");
            }
            else if(value == 10){
                sb.append("d");
            }
            else if(value == -10){
                sb.append("a");
            }
            
        }
        
        return sb.toString();
    }
}