class Solution {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> ans = new ArrayList<>();

        if (s.length() < 2) {
            return ans;
        }

        if (s.equals("--")) {
            return ans;
        }

        int i = 0;
        while (i < s.length()-1) {
            if (s.charAt(i) == s.charAt(i+1) && s.charAt(i) == '+') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.substring(0, i));
                sb.append('-');
                sb.append('-');
                sb.append(s.substring(i+2));

                ans.add(sb.toString());
            }

            i++;
        }

        return ans;
    }
}
