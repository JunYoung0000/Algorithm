class Solution {
    public String[] solution(String[] quiz) {
        String[] temp;
        String[] answer = new String[quiz.length];
        
        for(int i = 0; i < quiz.length; i++){
            temp = quiz[i].split(" ");
            int X = Integer.parseInt(temp[0]);
            int Y = Integer.parseInt(temp[2]);
            int Z = Integer.parseInt(temp[4]);
            
            switch(temp[1]){
                case "+":
                    if(X + Y == Z){
                        answer[i] = "O";
                    } else { 
                        answer[i] = "X";
                    }
                    break;
                    
                case "-":
                    if(X - Y == Z){
                        answer[i] = "O";
                    } else { 
                        answer[i] = "X";
                    }
                    break;
            }
        }

        return answer;
    }
}