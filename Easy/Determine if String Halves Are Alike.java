class Solution {

    private static final Set<Character> VOWELS = Set.of(
        'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'
    );

    public boolean halvesAreAlike(String s) {
        int count = 0;
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (VOWELS.contains(s.charAt(i))) {
                count++;
            }
            if (VOWELS.contains(s.charAt(i + n / 2))) {
                count--;
            }
        }
        return count == 0;
    }
}
