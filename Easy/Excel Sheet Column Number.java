class Solution {
    public int titleToNumber(String s) {
        int pow = 0;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            count += ((int) Math.pow(26, pow++)) * (s.charAt(i) - 'A' + 1);
        }
        
        return count;
    }
}
