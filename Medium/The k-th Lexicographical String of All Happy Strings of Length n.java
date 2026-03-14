class Solution {

    private static final char[] LETTERS = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        backtrack(n, happyStrings, new StringBuilder());
        if (happyStrings.size() < k) {
            return "";
        }
        Collections.sort(happyStrings);
        return happyStrings.get(k - 1);
    }

    private void backtrack(int n, List<String> happyStrings, StringBuilder sb) {
        if (sb.length() == n) {
            happyStrings.add(new String(sb.toString()));
            return;
        }
        for (char letter : LETTERS) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == letter) {
                continue;
            }
            sb.append(letter);
            backtrack(n, happyStrings, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
