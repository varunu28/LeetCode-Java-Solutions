class Solution {
    public static String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (Character.isLetter(chars[start]) && Character.isLetter(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }
            else if (Character.isLetter(chars[start]) && !Character.isLetter(chars[end])) {
                end--;
            }
            else if (!Character.isLetter(chars[start]) && Character.isLetter(chars[end])) {
                start++;
            }
            else {
                start++;
                end--;
            }
        }

        return String.valueOf(chars);
    }
}
