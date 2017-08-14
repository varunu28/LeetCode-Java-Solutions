public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        int mod = 0;
        while (n > 0) {
            mod = (n - 1) % 26;
            sb.append(String.valueOf((char) (65 + mod)));
            n = (n-mod)/26;
        }
        return sb.reverse().toString();
    }
}