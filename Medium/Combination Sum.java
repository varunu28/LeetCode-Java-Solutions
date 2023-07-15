class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> combination, List<List<Integer>> result, int idx) {
        if (target < 0 || idx == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(combination);
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            combination.add(candidates[i]);
            helper(candidates, target - candidates[i], new ArrayList<>(combination), result, i);
            combination.remove(combination.size() - 1);
        }
    }
}
