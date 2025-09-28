class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0};
        int maxX = board[0]/2;
        int minX = -(board[0]/2);
        int maxY = board[1]/2;
        int minY = -(board[1]/2);
        
        for(int i = 0; i < keyinput.length; i++){
            switch (keyinput[i]){
                case "up":
                    if(answer[1] < maxY)
                        answer[1] += 1;
                    break;
                case "down":
                    if(answer[1] > minY)
                        answer[1] -= 1;
                    break;
                case "left":
                    if(answer[0] > minX)
                        answer[0] -= 1;
                    break;
                case "right":
                    if(answer[0] < maxX)
                        answer[0] += 1;
                    break;
            }
        }
        
        return answer;
    }
}