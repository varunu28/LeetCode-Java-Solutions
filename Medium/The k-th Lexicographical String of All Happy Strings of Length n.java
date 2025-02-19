class Solution {
    private static final char[] CHARS = {'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        Set<String> set = new HashSet<>();
        backtrack(set, new StringBuilder(), n);
        if (set.size() < k) {
            return "";
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void backtrack(Set<String> set, StringBuilder sb, int n) {
        if (sb.length() == n) {
            set.add(sb.toString());
            return;
        }
        for (char c : CHARS) {
            if (sb.isEmpty() || sb.charAt(sb.length() - 1) != c) {
                sb.append(c);
                backtrack(set, sb, n);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
