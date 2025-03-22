class Solution {
    public int solution(String myString, String pat) {
        String changed = myString.replace("A", "X");
        changed = changed.replace("B", "A");
        changed = changed.replace("X", "B");
        
        return changed.contains(pat) ? 1 : 0;
    }
}