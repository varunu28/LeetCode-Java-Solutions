class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public String trimTrailingVowels(String s) {
        int idx = s.length() - 1;
        while (idx >= 0 && VOWELS.contains(s.charAt(idx))) {
            idx--;
        }
        return s.substring(0, idx + 1);
    }
}
