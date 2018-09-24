class Solution {
    public static int maxDistToClosest(int[] seats) {
        int left = -1;
        int max = 0;
        int length = seats.length;

        for (int i=0; i<length; i++) {
            if (seats[i] == 0) {
                continue;
            }

            if (left == -1) {
                max = Math.max(max, i);
            }
            else {
                max = Math.max(max, (i-left)/2);
            }

            left = i;
        }

        if (seats[length - 1] == 0) {
            max = Math.max(max, length - 1 - left);
        }
        
        return max;
    }
}
