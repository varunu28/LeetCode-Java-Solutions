class Solution {
    
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    
    public String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left <= right) {
            if (VOWELS.contains(chars[left]) && VOWELS.contains(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            } else if (!VOWELS.contains(chars[left])) {
                left++;
            } else if (!VOWELS.contains(chars[right])) {
                right--;
            }
        }
        return String.valueOf(chars);
    }
}
