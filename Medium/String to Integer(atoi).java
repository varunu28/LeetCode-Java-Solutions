class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }
        
        int idx = 0;
        int n = str.length();
        int sign = 1;
        while (idx < n && str.charAt(idx) == ' ') {
            idx++;
        }
        
        if (idx < n && (str.charAt(idx) == '-' || str.charAt(idx) == '+')) {
            sign = str.charAt(idx) == '-' ? -1 : 1;
            idx++;
        }
        
        long num = 0;
        while (idx < n && Character.isDigit(str.charAt(idx))) {
            num = num * 10 + Character.getNumericValue(str.charAt(idx++));
            
            if ((sign == 1 && num > Integer.MAX_VALUE) || (-num < Integer.MIN_VALUE)) {
                return getOverflowValue(sign);
            }
        }
        
        return sign * (int) num;
    }
    
    private int getOverflowValue(int sign) {
        return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
    }
}
