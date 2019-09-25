class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int total = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
            if (total > 5000) {
                break;
            }
            count++;
        }
        return count;
    }
}
