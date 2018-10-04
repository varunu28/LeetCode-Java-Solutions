class Solution {
    public static boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        }
        else if (s.length() - t.length() == 0) {
            if (s.equals(t)) {
                return false;
            }

            boolean missed = false;
            for (int i=0; i<s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) {
                    continue;
                }
                if (missed) {
                    return false;
                }
                
                missed = true;
            }
            return true;
        }

        return s.length() - t.length() == 1 ? oneDeleteOnly(s,t) : oneDeleteOnly(t,s);
    }

    private static boolean oneDeleteOnly(String s, String t) {
        if (t.length() == 0) {
            return true;
        }
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) != t.charAt(j)) {
                if (i > j) {
                    return false;
                }
                i++;
                continue;
            }

            i++;
            j++;
        }

        return true;
    }
}
