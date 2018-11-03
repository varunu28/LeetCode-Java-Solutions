class Solution {
    public String parseTernary(String expression) {
        if (expression.length() <= 1) {
            return expression;
        }

        int idx = expression.indexOf('?');
        int count = 0;

        while (idx < expression.length()) {
            if (expression.charAt(idx) == '?') {
                count++;
            }
            else if (expression.charAt(idx) == ':') {
                count--;
            }
            else if (count == 0) {
                break;
            }

            idx++;
        }

        String booleanCheck = expression.substring(0, expression.indexOf('?'));
        String left = expression.substring(expression.indexOf('?') + 1, idx-1);
        String right = expression.substring(idx);

        return booleanCheck.equals("T") ? parseTernary(left) : parseTernary(right);
    }
}
