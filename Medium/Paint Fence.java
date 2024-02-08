class Solution {
    public int numWays(int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        return numWays(n, k, map);
    }

    private int numWays(int n, int k, Map<Integer, Integer> map) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, (k - 1) * (numWays(n - 1, k, map) + numWays(n - 2, k, map)));
        return map.get(n);
    }
}
