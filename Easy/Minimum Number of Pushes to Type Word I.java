class Solution {
    public int minimumPushes(String word) {
        int pushes = 0;
        int idx = 0;
        int multiple = 1;
        while (idx < word.length()) {
            int count = Math.min(8, word.length() - idx);
            pushes += count * multiple;
            multiple++;
            idx += count;
        }
        return pushes;
    }
}
