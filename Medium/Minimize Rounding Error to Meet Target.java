class Solution {

    private static final double INF = 1e9;

    public String minimizeError(String[] prices, int target) {
        Map<String, Double> memo = new HashMap<>();
        double result = recurse(prices, target, 0, 0, memo);
        return result >= INF ? "-1" : String.format("%.3f", result);
    }

    private double recurse(String[] prices, int target, int curr, int idx, Map<String, Double> memo) {
        if (curr > target) {
            return INF;
        }
        if (idx == prices.length) {
            return curr == target ? 0.0 : INF;
        }
        String key = idx + "|" + curr;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        double price = Double.parseDouble(prices[idx]);
        double floor = Math.floor(price);
        double ceil = Math.ceil(price);
        double floorDiff = Math.abs(price - floor) + recurse(prices, target, curr + (int) floor, idx + 1, memo);
        double ceilDiff = Math.abs(price - ceil) + recurse(prices, target, curr + (int) ceil, idx + 1, memo);
        memo.put(key, Math.min(floorDiff, ceilDiff));
        return memo.get(key);
    }
}
