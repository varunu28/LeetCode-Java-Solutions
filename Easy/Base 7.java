class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = num < 0;
        num = Math.abs(num);
        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }
        if (isNegative) {
            sb.append('-');
        }
        return sb.isEmpty() ? "0" : sb.reverse().toString();
    }
}
