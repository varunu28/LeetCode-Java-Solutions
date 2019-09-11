class Solution {
    public int countLetters(String S) {
        int count = 0;
        int result = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i- 1)) {
                result++;
            }
            else {
                count += (result * (result + 1)) / 2;
                result = 1;
            }
        }
        return count + (result * (result + 1)) / 2;
    }
}
