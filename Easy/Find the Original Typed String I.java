class Solution {
    public int possibleStringCount(String word) {
        int idx = 0;
        int result = 1;
        while (idx < word.length()) {
            int currIdx = idx;
            char c = word.charAt(currIdx);
            while (currIdx < word.length() && word.charAt(currIdx) == c) {
                currIdx++;
            }
            int segement = currIdx - idx;
            result += segement - 1;
            idx = currIdx;
        }
        return result;
    }
}
