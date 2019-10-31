class Solution {
    public int balancedStringSplit(String s) {
        int count = 0;
        int val = 0;
        for (char c : s.toCharArray()) {
            val += c == 'L' ? -1 : 1;
            if (val == 0) {
                count++;
            }
        }
        return count;
    }
}
