class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, n, k, new ArrayList<>(), 1);
        return result;
    }

    private void helper(List<List<Integer>> result, int n, int k, List<Integer> curr, int currValue) {
        if (curr.size() == k) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int i = currValue; i <= n; i++) {
            if (!curr.isEmpty() && curr.get(curr.size() - 1) >= i) {
                continue;
            }
            curr.add(i);
            helper(result, n, k, curr, currValue + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
