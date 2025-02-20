class Solution {

    private static final char[] BINARY_CHARS = {'1', '0'};

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> binaryStrings = new HashSet<>();
        backtrack(new StringBuilder(), n, binaryStrings);
        Set<String> binaryStringsPresent = Arrays.stream(nums).collect(Collectors.toSet());
        binaryStrings.removeAll(binaryStringsPresent);
        return binaryStrings.isEmpty() ? "" : binaryStrings.iterator().next();
    }

    private void backtrack(StringBuilder sb, int n, Set<String> binaryStrings) {
        if (sb.length() == n) {
            binaryStrings.add(sb.toString());
            return;
        }
        for (char c : BINARY_CHARS) {
            sb.append(c);
            backtrack(sb, n, binaryStrings);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
