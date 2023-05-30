class Solution {
    public String removeTrailingZeros(String num) {
        int idx = num.length() - 1;
        while (idx >= 0 && num.charAt(idx) == '0') {
            idx--;
        }
        return num.substring(0, idx + 1);
    }
}
