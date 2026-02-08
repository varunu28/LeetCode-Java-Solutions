class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int vowelConsonantScore(String s) {
        int vowelCount = 0;
        int consonantCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                if (VOWELS.contains(c)) {
                    vowelCount++;
                } else {
                    consonantCount++;
                }
            }
        }
        return consonantCount == 0 ? 0 : (int) Math.floor(vowelCount / consonantCount);
    }
}
