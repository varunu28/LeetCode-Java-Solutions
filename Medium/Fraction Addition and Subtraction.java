class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int idx = 0;
        int n = expression.length();
        while (idx < n) {
            int currNumerator = 0;
            int currDenominator = 0;
            boolean negative = false;
            if (expression.charAt(idx) == '-' || expression.charAt(idx) == '+') {
                negative = expression.charAt(idx) == '-' ? true : false;
                idx++;
            }
            while (Character.isDigit(expression.charAt(idx))) {
                currNumerator = currNumerator * 10 + Character.getNumericValue(expression.charAt(idx));
                idx++;
            }
            if (negative) {
                currNumerator *= -1;
            }
            idx++;
            while (idx < n && Character.isDigit(expression.charAt(idx))) {
                currDenominator = currDenominator * 10 + Character.getNumericValue(expression.charAt(idx));
                idx++;
            }
            numerator = numerator * currDenominator + currNumerator * denominator;
            denominator = denominator * currDenominator;
        }
        int gcd = Math.abs(gcd(numerator, denominator));
        numerator /= gcd;
        denominator /= gcd;
        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
