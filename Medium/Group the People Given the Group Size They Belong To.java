class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            map.computeIfAbsent(groupSizes[i], k -> new ArrayList<>()).add(i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (Integer key : map.keySet()) {
            List<Integer> candidates = map.get(key);
            int idx = 0;
            while (idx < candidates.size()) {
                result.add(candidates.subList(idx, idx + key));
                idx += key;
            }
        }
        return result;
    }
}
