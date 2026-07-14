class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        int operations = 0;
        while (list.size() > 1) {
            boolean isAscending = true;
            int minSum = Integer.MAX_VALUE;
            int targetIdx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (list.get(i) > list.get(i + 1)) {
                    isAscending = false;
                }
                if (sum < minSum) {
                    minSum = sum;
                    targetIdx = i;
                }
            }
            if (isAscending) {
                break;
            }
            operations++;
            list.set(targetIdx, minSum);
            list.remove(targetIdx + 1);
        }
        return operations;
    }
}
