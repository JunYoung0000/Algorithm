class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i = 0; i < dic.length; i++){
            boolean torf = true;
            
            for(int m = 0; m < spell.length; m++){
                if(!dic[i].contains(spell[m]))
                    torf = false;
            }
            
            if(torf) return 1;
        }
        return 2;
    }
}