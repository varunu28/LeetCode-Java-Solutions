class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        return (int) Arrays.stream(words)
                .skip(left)
                .limit(right - left + 1)
                .filter(word -> vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(word.length() - 1)))
                .count();
    }
}
