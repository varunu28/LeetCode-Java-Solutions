class Solution {
    public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> creditMap = new HashMap<>();
        for (int[] transaction : transactions) {
            int from = transaction[0];
            int to = transaction[1];
            int amount = transaction[2];
            creditMap.put(from, creditMap.getOrDefault(from, 0) - amount);
            creditMap.put(to, creditMap.getOrDefault(to, 0) + amount);
        }
        List<Integer> creditList = new ArrayList<>();
        for (Integer credit : creditMap.values()) {
            if (credit != 0) {
                creditList.add(credit);
            }
        }
        int n = creditList.size();
        return dfs(0, n, creditList);
    }

    private int dfs(int curr, int n, List<Integer> creditList) {
        while (curr < n && creditList.get(curr) == 0) {
            curr++;
        }
        if (curr == n) {
            return 0;
        }
        int transactions = Integer.MAX_VALUE;
        for (int next = curr + 1; next < n; next++) {
            if (creditList.get(next) * creditList.get(curr) < 0) {
                creditList.set(next, creditList.get(next) + creditList.get(curr));
                transactions = Math.min(transactions, 1 + dfs(curr + 1, n, creditList));
                creditList.set(next, creditList.get(next) - creditList.get(curr));
            }
        }
        return transactions;
    }
}
