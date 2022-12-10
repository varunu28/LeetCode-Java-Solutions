class Solution {
    public int maximumValue(String[] strs) {
        return Arrays.stream(strs)
                .mapToInt(Solution::getStringValue)
                .max()
                .orElse(0);
    }

    private static int getStringValue(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return s.length();
            }
        }
        return Integer.parseInt(s);
    }
}
