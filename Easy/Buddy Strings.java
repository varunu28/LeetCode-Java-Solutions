class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int mismatchIdx = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (mismatchIdx == Integer.MAX_VALUE) {
                    return false;
                }
                if (mismatchIdx == -1) {
                    mismatchIdx = i;
                } else {
                    if (!(s.charAt(mismatchIdx) == goal.charAt(i) && s.charAt(i) == goal.charAt(mismatchIdx))) {
                        return false;
                    }
                    mismatchIdx = Integer.MAX_VALUE;
                }
            } else {
                set.add(s.charAt(i));
            }
        }
        if (mismatchIdx != -1 && mismatchIdx != Integer.MAX_VALUE) {
            return false;
        }
        if (mismatchIdx == -1) {
            return s.length() > set.size();
        }
        return true;
    }
}
