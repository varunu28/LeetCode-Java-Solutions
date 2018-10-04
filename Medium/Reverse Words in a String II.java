class Solution {
    public static void reverseWords(char[] str) {
        int end = str.length-1;
        int start = 0;
        char[] ans = new char[str.length];
        
        while(end >= 0) {
            while (end >= 0  && str[end] != ' ') {
                end--;
            }

            int len = str.length - end - 1;
            int temp = end + 1;

            while (start < len) {
                ans[start++] = str[temp++];
            }

            if (start < str.length) {
                ans[start++] = ' ';
                end--;
            }
        }

        for(int i=0; i<ans.length; i++) {
            str[i] = ans[i];
        }
    }
}
