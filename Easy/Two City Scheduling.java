class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });

        int total = 0;
        for (int i = 0; i < costs.length; i++) {
            if (i < costs.length / 2) {
                total += costs[i][0];
            }
            else {
                total += costs[i][1];
            }
        }
        
        return total;
    }
}
