class Solution {
    public static void reverseWords(char[] str) {
        reverse(str, 0, str.length);

        int start = 0;
        for (int i=0; i<str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i);
                start = i + 1;
            }
        }

        reverse(str, start, str.length);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i=0; i<(end - start)/2; i++) {
            swap(str, start+i, end-i-1);
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
