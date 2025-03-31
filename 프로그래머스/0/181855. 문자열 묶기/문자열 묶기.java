class Solution {
    public int solution(String[] strArr) {
        int length = strArr.length;
        int[] st_num = new int[length];
        
        for(int i = 0; i < length; i++){
            st_num[i] = strArr[i].length();
        }
        
        int[] hwmany = new int[31];
        for(int j = 0; j < hwmany.length; j++){
            hwmany[j] = 0;
        }
        
        for(int value : st_num){
            hwmany[value]++;
        }
        
        int max_group = 0;
        for(int num : hwmany){
            if(max_group < num){
                max_group = num;
            }
        }
        return max_group;
    }
}