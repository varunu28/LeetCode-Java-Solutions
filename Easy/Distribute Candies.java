class Solution {
    public int distributeCandies(int[] candies) {
        Map<Integer, Integer> count = new HashMap<>();
        int unique = 0;
        int n = candies.length;
        for (int i=0;i<n;i++) {
            if (!count.containsKey(candies[i])) {
                unique++;
            }
            count.put(candies[i],1);
        }

        return unique > n/2 ? n/2 : unique;
    }
}
