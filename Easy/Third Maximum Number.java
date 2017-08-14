public class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> arr = new ArrayList();
        for (int i=0;i<nums.length;i++) {
            if (arr.indexOf(nums[i]) == -1) {
                arr.add(nums[i]);
            }
        }
        if (arr.size() >= 3) {
            return arr.get(arr.size()-3);
        }
        else {
            return arr.get(arr.size()-1);
        }
    }
}