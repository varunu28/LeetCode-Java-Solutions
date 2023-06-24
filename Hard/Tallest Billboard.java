class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        Map<Integer, Integer> firstHalf = helper(rods, 0, n / 2);
        Map<Integer, Integer> secondHalf = helper(rods, n / 2, n);
        int result = 0;
        for (Integer difference : firstHalf.keySet()) {
            if (secondHalf.containsKey(-1 * difference)) {
                result = Math.max(result, firstHalf.get(difference) + secondHalf.get(-1 * difference));
            }
        }
        return result;
    }
    
    private Map<Integer, Integer> helper(int[] rods, int leftIdx, int rightIdx) {
        Set<Pair<Integer, Integer>> states = new HashSet<>();
        states.add(new Pair(0, 0));
        for (int i = leftIdx; i < rightIdx; i++) {
            int rod = rods[i];
            Set<Pair<Integer, Integer>> newStates = new HashSet<>();
            for (Pair<Integer, Integer> state : states) {
                newStates.add(new Pair(state.getKey() + rod, state.getValue()));
                newStates.add(new Pair(state.getKey(), state.getValue() + rod));
            }
            states.addAll(newStates);
        }
        Map<Integer, Integer> dp = new HashMap<>();
        for (Pair<Integer, Integer> pair : states) {
            Integer left = pair.getKey();
            Integer right = pair.getValue();
            dp.put(left - right, Math.max(dp.getOrDefault(left - right, 0), left));
        }
        return dp;
    }
}
