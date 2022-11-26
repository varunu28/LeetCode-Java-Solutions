class Solution {
    public boolean isDecomposable(String s) {
        boolean sizeTwoFound = false;
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            int tempIdx = idx;
            while (tempIdx < s.length() && s.charAt(tempIdx) == c && tempIdx - idx < 3) {
                tempIdx++;
            }
            int occurrences = tempIdx - idx;
            if (occurrences < 2) {
                return false;
            }
            if (occurrences == 2) {
                if (sizeTwoFound) {
                    return false;
                }
                sizeTwoFound = true;
            }
            idx = tempIdx;
        }
        return sizeTwoFound;
    }       
}
