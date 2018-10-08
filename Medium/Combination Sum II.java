class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> perms = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        combinationSumHelper(candidates, target, perms, temp, 0);

        return perms;
    }

    private static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> perms, List<Integer> temp, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            perms.add(new ArrayList<>(temp));
        }
        else {
            for (int i=start; i<candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i-1]) {
                    continue;
                }
                temp.add(candidates[i]);
                combinationSumHelper(candidates, target-candidates[i], perms, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
