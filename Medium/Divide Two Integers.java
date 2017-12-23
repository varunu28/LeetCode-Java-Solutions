class Solution {
    public int divide(int dividend, int divisor) {
        
        boolean isNeg = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            isNeg = true;
        }
        
        int ans = 0;
        
        long Ldividend = Math.abs((long) dividend);
        long Ldivisor = Math.abs((long) divisor);
        
        if (Ldivisor == 0) return Integer.MAX_VALUE;
        if (Ldividend == 0 || (Ldividend < Ldivisor)) return 0;
        
        long quot = ldivide(Ldividend, Ldivisor);
        
        if(quot > Integer.MAX_VALUE) {
            ans = isNeg == false ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        else {
            ans = (int)(isNeg ? -quot : quot);
        }
        
        return ans;
    }
    
    private long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) return 0;
        
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }

        return multiple + ldivide(ldividend - sum, ldivisor);
    }
}
