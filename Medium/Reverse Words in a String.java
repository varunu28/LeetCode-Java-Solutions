public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        StringBuilder temp = new StringBuilder();
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                while (i >= 0 && s.charAt(i) != ' ') {
                    temp.append(s.charAt(i));
                    i--;
                }

                sb.append(temp.reverse().toString()).append(" ");
                temp = new StringBuilder();
            }

            i--;
        }

        if (temp.length() > 0) {
            sb.append(temp.reverse().toString());
        }

        return sb.toString().trim();
    }
}
