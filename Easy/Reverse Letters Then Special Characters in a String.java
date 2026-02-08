class Solution {
    public String reverseByType(String s) {
        char[] letters = s.toCharArray();
        reverse(letters, true);
        reverse(letters, false);
        return String.valueOf(letters);
    }

    private void reverse(char[] letters, boolean isLetter) {
        int start = 0;
        int end = letters.length - 1;
        while (start < end) {
            if (Character.isLetter(letters[start]) == isLetter) {
                start++;
            } else if (Character.isLetter(letters[end]) == isLetter) {
                end--;
            } else {
                char temp = letters[start];
                letters[start] = letters[end];
                letters[end] = temp;
                start++;
                end--;
            }
        }
    }
}
