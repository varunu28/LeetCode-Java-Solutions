class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] counter = new int[10];
        int smallestOne = nums1[0];
        int smallestTwo = nums2[0];
        for (int num : nums1) {
            counter[num]++;
            smallestOne = Math.min(smallestOne, num);
        }
        for (int num : nums2) {
            counter[num]++;
            smallestTwo = Math.min(smallestTwo, num);
        }
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 2) {
                return i;
            }
        }
        return Math.min(smallestOne, smallestTwo) * 10 + Math.max(smallestOne, smallestTwo);
    }
}
