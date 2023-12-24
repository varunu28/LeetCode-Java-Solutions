class Solution {
    public int minOperations(String s) {
        int startZero = 0;
        int startOne = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                startOne += s.charAt(i) == '0' ? 1 : 0;
                startZero += s.charAt(i) == '1' ? 1 : 0;
            } else {
                startOne += s.charAt(i) == '1' ? 1 : 0;
                startZero += s.charAt(i) == '0' ? 1 : 0;
            }
        }
        return Math.min(startZero, startOne);
    }
}
