class Solution {
    public int largestInteger(int n, int s) {
        if (s == 0) {
            return 0;
        }
        if (s <= 9) {
            return Integer.parseInt(s + "0".repeat(n - 1));
        }
        int digit = 9;
        StringBuilder sb = new StringBuilder();
        while (s > 0 && n-- > 0) {
            sb.append(digit);
            s -= digit;
            digit = Math.min(digit, s);
        }
        if (s != 0) {
            return -1;
        }
        sb.append("0".repeat(Math.max(0, n)));
        return Integer.parseInt(sb.toString());
    }
}
