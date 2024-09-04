class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] removed = queue.remove();
            int x = removed[0];
            int y = removed[1];
            result.add(nums.get(x).get(y));
            // move down in column first
            if (y == 0 && x + 1 < nums.size()) {
                queue.add(new int[]{x + 1, y});
            }
            // then pick the next element in row
            if (y + 1 < nums.get(x).size()) {
                queue.add(new int[]{x, y + 1});
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
