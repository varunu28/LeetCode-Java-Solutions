class Solution {
    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int player = 1;
        int multiple = k;
        while (set.add(player)) {
            player = (player + k) % n;
            player = player == 0 ? n : player;
            k += multiple;
        }
        int[] result = new int[n - set.size()];
        for (int i = 1, j = 0; i <= n; i++) {
            if (!set.contains(i)) {
                result[j++] = i;
            }
        }
        return result;
    }
}
