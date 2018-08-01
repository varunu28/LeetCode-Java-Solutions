class Solution {
    public static boolean backspaceCompare(String S, String T) {
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");

        for (char c : S.toCharArray()) {
            if (c == '#' && s1.length() != 0) {
                s1.delete(s1.length()-1, s1.length());
            }
            else if (c != '#') {
                s1.append(c);
            }
        }

        for (char c : T.toCharArray()) {
            if (c == '#' && s2.length() != 0) {
                s2.delete(s2.length()-1, s2.length());
            }
            else if (c != '#') {
                s2.append(c);
            }
        }

        return s1.toString().equals(s2.toString());
    }
}
