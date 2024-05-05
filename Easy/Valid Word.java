class Solution {

    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean isValid(String word) {
        boolean vowelFound = false;
        boolean consonantFound = false;
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                if (VOWELS.contains(c)) {
                    vowelFound = true;
                } else {
                    consonantFound = true;
                }
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return word.length() >= 3 && vowelFound && consonantFound;
    }
}
