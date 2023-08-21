class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i > 0; i--) {
            if (n % i == 0) {
                int count = n / i;
                String substring = s.substring(0, i);
                String repeatedString = substring.repeat(count);
                if (repeatedString.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
