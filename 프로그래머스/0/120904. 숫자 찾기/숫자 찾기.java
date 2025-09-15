class Solution {
    public int solution(int num, int k) {
        String numToString = String.valueOf(num);
        String kToString = String.valueOf(k);
        
        int index = numToString.indexOf(kToString);
        return (index == -1) ? -1 : index + 1;
    }
}