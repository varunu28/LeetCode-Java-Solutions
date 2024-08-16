class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int n = arrays.get(0).size();
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(n - 1);
        for (int i = 1; i < arrays.size(); i++) {
            n = arrays.get(i).size();
            result = Math.max(result, 
                Math.max(Math.abs(arrays.get(i).get(n - 1) - min), 
                        Math.abs(max - arrays.get(i).get(0))));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(n - 1));
        }
        return result;
    }
}
