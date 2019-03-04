class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        int idx = 0;
        int n = str.length();

        // Removing initial white spaces
        while (idx < n && str.charAt(idx) == ' ') {
            idx++;
        }

        int sign = 1;
        // Updating sign value if there is a '+' or '-' present
        if (idx < n) {
            if (str.charAt(idx) == '-') {
                sign = -1;
                idx++;
            }
            else if (str.charAt(idx) == '+') {
                idx++;
            }
        }

        // Integer limits
        int positiveLimit = Integer.MAX_VALUE;
        int negativeLimit = Integer.MIN_VALUE;

        // Adding values to StringBuilder until a digit is found
        // Keeping a check for bounds
        while (idx < n && Character.isDigit(str.charAt(idx))) {
            sb.append(str.charAt(idx));
            if (sign == 1 && Long.parseLong(sb.toString()) > positiveLimit) {
                return Integer.MAX_VALUE;
            }

            if (sign == -1 && Long.parseLong(sb.toString()) * sign < negativeLimit) {
                return Integer.MIN_VALUE;
            }

            idx++;
        }

        if (sb.length() == 0) {
            return 0;
        }

        return (int) (Long.parseLong(sb.toString()) * sign);
    }
}
