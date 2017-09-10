class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int[][] arr = new int[nums.length/2][2];

        for (int i=0,j=0;i<nums.length;i+=2) {
            arr[j][0] = nums[i];
            arr[j][1] = nums[i+1];
            j++;
        }

        int sum = 0;
        for (int i=0;i<nums.length/2;i++) {
            sum += arr[i][0];
        }

        return sum;
    }
}
