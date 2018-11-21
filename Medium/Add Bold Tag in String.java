class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;

        for (int i=0; i<s.length(); i++) {
            boolean found = false;
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    found = true;
                    end = Math.max(end, i + word.length());
                }

                int j = i;
                if (found) {
                    while (j < end) {
                        bold[j] = found;
                        j++;
                    }
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                continue;
            }

            int j = i;
            while (j < s.length() && bold[j]) {
                j++;
            }
            sb.append("<b>").append(s.substring(i, j) + "</b>");
            i = j-1;
        }

        return sb.toString();
    }
}
