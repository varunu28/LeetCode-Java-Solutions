class Solution {
    public boolean isPalindromic(String s) {
        return isPalindrome(buildBinaryString(s));
    }

    private String buildBinaryString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            String binary = Integer.toBinaryString((int) c);
            if (binary.length() < 8) {
                sb.append("0".repeat(8 - binary.length()));
            }
            sb.append(binary);
        }
        return sb.toString();
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }   
}
