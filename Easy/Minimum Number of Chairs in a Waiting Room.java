class Solution {
    public int minimumChairs(String s) {
        int requiredChairCount = 0;
        int currChairCount = 0;
        for (char c : s.toCharArray()) {
            currChairCount += c == 'E' ? 1 : -1;
            requiredChairCount = Math.max(requiredChairCount, currChairCount);
        }
        return requiredChairCount;
    }
}
