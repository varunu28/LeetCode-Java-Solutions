class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (x <= arr[0]) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(0, k);
        }
        else if (x >= arr[arr.length - 1]) {
            return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(arr.length - k, arr.length);
        }
        else {
            int idx = Arrays.binarySearch(arr, x);
            if (idx < 0) {
                idx = -idx - 1;
            }
            int low = Math.max(0, idx - k - 1);
            int high = Math.min(arr.length - 1, idx + k - 1);

            while (high - low > k - 1) {
                if (low < 0 || (x - arr[low]) <= (arr[high] - x)) {
                    high--;
                }
                else if ((high > arr.length - 1 || (x - arr[low]) > (arr[high] - x))) {
                    low++;
                }
            }

            return Arrays.stream(arr).boxed().collect(Collectors.toList()).subList(low, high + 1);
        }
    }
}
