class Solution {
    public int bitwiseComplement(int N) {
        String binaryString = getInvertedBinaryString(N);
        return getDecimalVal(binaryString);
    }
    
    private String getInvertedBinaryString(int n) {
        if (n == 0) {
            return "1";
        }
        
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2 == 0 ? 1 : 0);
            n /= 2;
        }
        
        return sb.reverse().toString();
    }
    
    private int getDecimalVal(String s) {
        int pow = 0;
        int sum = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            sum += Math.pow(2, pow) * Character.getNumericValue(s.charAt(i));
            pow++;
        }
        
        return sum;
    }
}
