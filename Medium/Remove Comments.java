class Solution {
    public List<String> removeComments(String[] source) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int n = source.length;
        boolean blockComment = false;
        StringBuilder sb = new StringBuilder();

        for (i = 0; i < n; i++) {
            String line = source[i];

            for (int j = 0; j < line.length(); j++) {
                if (!blockComment) {
                    if (j + 1 < line.length() && line.charAt(j) == '/' && line.charAt(j + 1) == '/') {
                        break;
                    }
                    else if (j + 1 < line.length() && line.charAt(j) == '/' && line.charAt(j+1) == '*') {
                        blockComment = true;
                        j++;
                    }
                    else {
                        sb.append(line.charAt(j));
                    }
                }
                else {
                    if (j + 1 < line.length() && line.charAt(j) == '*' && line.charAt(j + 1) == '/') {
                        blockComment = false;
                        j++;
                    }
                }
            }

            if (sb.length() > 0 && !blockComment) {
                ans.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return ans;
    }
}
