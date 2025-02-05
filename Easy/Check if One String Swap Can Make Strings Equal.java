class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int swapIdx = -1;
        boolean swapped = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (swapped) {
                    return false;
                }
                if (swapIdx != -1) {
                    if (!(s1.charAt(swapIdx) == s2.charAt(i) && s1.charAt(i) == s2.charAt(swapIdx))) {
                        return false;
                    }
                    swapped = true;
                } 
                swapIdx = i;
            }
        }
        return swapIdx == -1 || (swapIdx != -1 && swapped);
    }
}
