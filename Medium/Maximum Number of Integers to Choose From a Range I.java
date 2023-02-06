class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int count = 0;
        Set<Integer> bannedSet = Arrays.stream(banned).boxed().collect(Collectors.toSet());
        for (int i = 1; i <= n && count < n; i++) {
            if (bannedSet.contains(i)) {
                continue;
            }
            if (maxSum - i < 0) {
                break;
            }
            count++;
            maxSum -= i;
        }
        return count;
    }
}
