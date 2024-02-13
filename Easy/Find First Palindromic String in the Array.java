class Solution {
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words)
            .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
            .findFirst()
            .orElse("");
    }
}
