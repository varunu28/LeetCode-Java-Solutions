class Solution {
    public int removeAlmostEqualCharacters(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            char curr = word.charAt(i);
            char next = word.charAt(i + 1);
            if (Math.abs(curr - next) <= 1) {
                count++;
                i++;
            }
        }
        return count;
    }
}
