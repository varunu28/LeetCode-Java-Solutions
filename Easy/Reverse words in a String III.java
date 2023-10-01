class Solution {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        while (end < s.length()) {
            if (chars[end] == ' ') {
                if (start < end - 1) {
                    reverse(chars, start, end - 1);
                }
                end++;
                start = end;
            } else {
                end++;
            }
        }
        if (start < end) {
            reverse(chars, start, end - 1);
        }
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}
