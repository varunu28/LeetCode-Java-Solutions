class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int remainder = n % -2;
            n /= -2;
            if (remainder < 0) {
                remainder = 1;
                n++;
            }
            sb.append(remainder);
        }
        return sb.reverse().toString();
    }
}
