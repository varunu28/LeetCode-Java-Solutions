class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<String, Integer> map = new HashMap <>();
        for (int i = 0; i < dominoes.length; i++) {
            String key = Math.min(dominoes[i][0], dominoes[i][1]) + "|" + Math.max(dominoes[i][0], dominoes[i][1]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int count = 0;
        for (int value : map.values()) {
            count += (value * (value - 1)) / 2;
        }
        
        return count;
    }
}
