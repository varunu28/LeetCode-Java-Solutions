class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int diff = Math.abs(s.length() - t.length());
        if (s.equals(t) || diff > 1) {
            return false;
        }
        int idx = 0;
        while (idx < s.length() && idx < t.length()) {
            if (s.charAt(idx) != t.charAt(idx)) {
                // Replace character
                if (s.substring(idx + 1).equals(t.substring(idx + 1))) {
                    return true;
                }
                // Delete 1 character from s
                if (s.substring(idx + 1).equals(t.substring(idx))) {
                    return true;
                }
                // Delete 1 character from t
                if (s.substring(idx).equals(t.substring(idx + 1))) {
                    return true;
                }
                return false;
            }
            idx++;
        }
        return true;
    }
}
