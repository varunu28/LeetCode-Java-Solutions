class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();

        for (char c : chars) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            }
            else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
