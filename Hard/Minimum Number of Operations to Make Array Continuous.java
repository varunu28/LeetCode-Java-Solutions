class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int[] arr = new int[set.size()];
        int idx = 0;
        for (Integer num : set) {
            arr[idx++] = num;
        }
        Arrays.sort(arr);
        int n = nums.length;
        int result = n;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            while (j < arr.length && arr[j] < arr[i] + n) {
                j++;
            }
            int count = j - i;
            result = Math.min(result, n - count);
        }
        return result;
    }
}
