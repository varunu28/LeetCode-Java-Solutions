class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] temp = new int[pairs.length];
        Arrays.fill(temp, 1);
        for (int i=1; i<pairs.length; i++) {
            for (int j=0; j<i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    temp[i] = Math.max(temp[i], temp[j] + 1);
                }
            }
        }

        return Arrays.stream(temp).max().getAsInt();
    }
}
