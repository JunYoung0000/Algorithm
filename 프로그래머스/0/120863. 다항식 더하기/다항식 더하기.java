class Solution {
    public String solution(String polynomial) {
        String[] arr = polynomial.split(" \\+ ");
        int num = 0;
        int x = 0;
        
        for (String str : arr) {
            if (str.endsWith("x")) {
                if (str.length() == 1) {
                    x += 1;
                } else {
                    x += Integer.parseInt(str.replace("x", ""));
                }
            } else {
                num += Integer.parseInt(str);
            }
        }
        
        if (x != 0 && num != 0) {
            return (x == 1 ? "x" : x + "x") + " + " + num;
        } else if (x != 0) {
            return (x == 1 ? "x" : x + "x");
        } else {
            return String.valueOf(num);
        }
    }
}
