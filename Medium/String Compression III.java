class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < word.length()) {
            char c = word.charAt(idx);
            int count = 0;
            while (idx < word.length() && word.charAt(idx) == c && count < 9) {
                idx++;
                count++;
            }
            sb.append(count).append(c);
        }
        return sb.toString();
    }
}
