class Solution {
    public String boldWords(String[] words, String S) {
        if (S.length() == 0 || words.length == 0) {
            return S;
        }

        int l = S.length();
        int[] match = new int[l];

        for (String word : words) {
            int idx = 0;
            while (idx < l) {
                int startIdx = S.indexOf(word, idx);
                if (startIdx != -1) {
                    for (int i = startIdx; i < startIdx + word.length(); i++) {
                        match[i] = 1;
                    }

                    idx = startIdx + 1;
                }
                else {
                    break;
                }
            }
        }

        String startTag = "<b>";
        String endTag = "</b>";

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<l; i++) {
            if ((i == 0 || match[i-1] == 0) && match[i] == 1) {
                sb.append(startTag);
            }
            sb.append(S.charAt(i));
            if ((i == l-1 || match[i+1] == 0) && match[i] == 1) {
                sb.append(endTag);
            }
        }

        return sb.toString();
    }
}
