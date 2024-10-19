class Solution {
    public char findKthBit(int n, int k) {
        return nthString(n).charAt(k - 1);
    }

    private String nthString(int n) {
        if (n == 1) {
            return "0";
        }
        String prevString = nthString(n - 1);
        return prevString + "1" + reverseAndInvert(prevString);
    }

    private String reverseAndInvert(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            chars[i] = chars[i] == '1' ? '0' : '1';
        }
        StringBuilder sb = new StringBuilder(String.valueOf(chars));
        return sb.reverse().toString();
    }
}
