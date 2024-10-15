class Solution {
    public long minimumSteps(String s) {
        int whitePos = 0;
        long swaps = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                swaps += i - whitePos;
                whitePos++;
            }
        }
        return swaps;
    }
}
