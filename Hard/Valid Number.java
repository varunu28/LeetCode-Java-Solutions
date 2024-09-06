class Solution {
    public boolean isNumber(String s) {
        int idx = 0;
        boolean isDecimal = false;
        boolean isDigit = false;
        boolean digitsBeforeDecimal = false;
        boolean digitsAfterDecimal = false;
        int n = s.length();
        if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
            idx++;
        }
        while (idx < n) {
            if (s.charAt(idx) == '.') {
                if (isDecimal) {
                    return false;
                }
                isDecimal = true;
            } else if (s.charAt(idx) == 'e' || s.charAt(idx) == 'E') {
                if (!isDigit) {
                    return false;
                }
                boolean valid = isValidExponent(s, idx + 1);
                if (!valid) {
                    return false;
                }
                break;
            } else if (Character.isDigit(s.charAt(idx))) {
                if (isDecimal) {
                    digitsAfterDecimal = true;
                } else {
                    digitsBeforeDecimal = true;
                }
                isDigit = true;
            } else {
                return false;
            }
            idx++;
        }
        if (isDecimal) {
            return digitsBeforeDecimal || digitsAfterDecimal;
        }
        return isDigit;
    } 

    private boolean isValidExponent(String s, int idx) {
        if (idx == s.length()) {
            return false;
        }
        if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
            idx++;
        }
        boolean digitFound = false;
        while (idx < s.length()) {
            if (!Character.isDigit(s.charAt(idx))) {
                return false;
            }
            digitFound = true;
            idx++;
        }
        return digitFound;
    }
}
