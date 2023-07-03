class Solution {
    
    private static final int SWAP_DONE_IDX = Integer.MIN_VALUE;
    
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        int swapIdx = -1;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(i)) {
                set.add(s.charAt(i));
                continue;
            }
            if (s.charAt(i) != goal.charAt(i)) {
                if (swapIdx == SWAP_DONE_IDX) {
                    return false;
                }
                if (swapIdx == -1) {
                    swapIdx = i;
                    continue;
                } 
                if (!(s.charAt(swapIdx) == goal.charAt(i) && s.charAt(i) == goal.charAt(swapIdx))) {
                    return false;
                }
                swapIdx = SWAP_DONE_IDX;
            }
        }
        return (swapIdx != -1 && swapIdx == SWAP_DONE_IDX) || (swapIdx == -1 && set.size() < s.length());
    }
}
