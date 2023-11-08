class Solution {
    public int getWinner(int[] arr, int k) {
        int curr = arr[0];
        int streak = 0;
        for (int i = 1; i < arr.length; i++) {
            if (curr < arr[i]) {
                curr = arr[i];
                streak = 0;
            } 
            if (++streak == k) {
                break;
            }
        }
        return curr;
    }
}
