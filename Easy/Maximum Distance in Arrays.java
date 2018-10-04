class Solution {
    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int result = Integer.MIN_VALUE;

        for (int i=1; i<arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min));
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));

            max = Math.max(max, arrays.get(i).get(arrays.get(i).size()-1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;
    }
}
