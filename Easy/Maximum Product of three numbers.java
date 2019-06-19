class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (max1 == Integer.MIN_VALUE) {
                max1 = num;
            }
            else if (max2 == Integer.MIN_VALUE) {
                if (num > max1) {
                    max2 = max1;
                    max1 = num;
                }
                else {
                    max2 = num;
                }
            }
            else if (max3 == Integer.MIN_VALUE) {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }
                else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                }
                else {
                    max3 = num;
                }
            }
            else {
                if (num > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }
                else if (num > max2) {
                    max3 = max2;
                    max2 = num;
                }
                else {
                    max3 = Math.max(max3, num);
                }
            }
            
            if (min1 == Integer.MIN_VALUE) {
                min1 = num;
            }
            else if (min2 == Integer.MIN_VALUE) {
                if (min1 > num) {
                    min2 = min1;
                    min1 = num;
                }
                else {
                    min2 = num;
                }
            }
            else {
                if (min1 > num) {
                    min2 = min1;
                    min1 = num;
                }
                else {
                    min2 = Math.min(min2, num);
                }
            }
        }
        
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
