class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        helper(list, temp, k, n, 0, 1);

        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> temp, int k, int n, int sum, int start) {
        if (sum == n && temp.size() == k) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i=start; i<=9; i++) {
            // Choose
            temp.add(i);
            sum += i;

            // Explore
            helper(list, temp, k, n, sum, i+1);

            // Un-choose
            sum -= temp.get(temp.size() - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
