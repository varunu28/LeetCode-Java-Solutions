class Solution {
    public int minIncrementForUnique(int[] arr) {
        int count = 0;

        Arrays.sort(arr);
        int previous = Integer.MIN_VALUE;

        for (int i=0; i<arr.length; i++) {
            if (previous != Integer.MIN_VALUE && previous >= arr[i]) {
                count += previous - arr[i] == 0 ? 1 : previous + 1 - arr[i];
                arr[i] = previous + 1;
            }

            previous = arr[i];
        }

        return count;
    }
}
