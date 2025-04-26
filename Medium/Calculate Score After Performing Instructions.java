class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        long result = 0;
        int n = values.length;
        int idx = 0;
        Set<Integer> executed = new HashSet<>();
        while (idx < n && idx >= 0) {
            if (!executed.add(idx)) {
                break;
            }
            if (instructions[idx].equals("add")) {
                result += values[idx++];
            } else {
                idx += values[idx];
            }
        }
        return result;
    }
}
