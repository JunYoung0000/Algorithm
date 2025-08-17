import java.math.BigInteger;

class Solution {
    public BigInteger solution(int balls, int share) {
        BigInteger molecule = factorial(balls);
        BigInteger a = factorial(balls - share);
        BigInteger b = factorial(share);
        
        return molecule.divide(a.multiply(b));
    }

    public BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}