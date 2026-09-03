class Solution {
    public boolean uniformArray(int[] nums1) {
        int smallestOdd = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num % 2 != 0) {
                smallestOdd = Math.min(smallestOdd, num); 
            }
        }
        if (smallestOdd == Integer.MAX_VALUE) {
            return true;
        }
        for (int num : nums1) {
            if (num % 2 == 0 && smallestOdd > num) {
                return false;
            }
        }
        return true;
    }
}
