class Solution {
    Set<List<Integer>> set;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        set = new HashSet<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target, new ArrayList<>());
        
        return new ArrayList<>(set);
    }
    
    private void combinationSumHelper(int[] candidates, int currVal, int target, List<Integer> list) {
        if (currVal == target) {
            set.add(new ArrayList<>(list));
            return;
        }
        
        if (currVal > target) {
            return;
        }
        
        for (int i = 0; i < candidates.length; i++) {
            if (list.size() > 0 && list.get(list.size() - 1) > candidates[i]) {
                continue;
            }
 
            // Choose
            currVal += candidates[i];
            list.add(candidates[i]);
            
            // Explore
            combinationSumHelper(candidates, currVal, target, list);
            
            // Unchoose
            list.remove(list.size() - 1);
            currVal -= candidates[i];
        }
    } 
}
