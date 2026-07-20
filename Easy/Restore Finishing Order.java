class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        boolean[] present = new boolean[n + 1];
        int m = friends.length;
        for (int i = 0; i < m; i++) {
            present[friends[i]] = true;
        }
        int[] result = new int[m];
        int idx = 0;
        for (int o : order) {
            if (present[o]) {
                result[idx++] = o;
            }
        }
        return result;
    }
}
