class Solution {
    public int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;
        int[] maxRightIdx = new int[n];
        maxRightIdx[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            maxRightIdx[i] = (digits[i] > digits[maxRightIdx[i + 1]]) ? i : maxRightIdx[i + 1];
        }
        for (int i = 0; i < n; i++) {
            if (digits[i] < digits[maxRightIdx[i]]) {
                char temp = digits[i];
                digits[i] = digits[maxRightIdx[i]];
                digits[maxRightIdx[i]] = temp;
                return Integer.parseInt(String.valueOf(digits));
            }
        }
        return num;
    }
}
