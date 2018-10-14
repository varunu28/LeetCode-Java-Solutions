class Solution {
    public int threeSumMulti(int[] A, int target) {
        int div = 1000000007;
        int count = 0;
        for (int i=0; i<A.length; i++) {
            int temp = getPairsCount(A.length, target-A[i], A, i+1);
            count = (count+temp)%div;
        }
        return count;
    }

    public int getPairsCount(int n, int sum, int[] arr, int start) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=start; i<n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        int count = 0;
        for (int i=start; i<n; i++) {
            if(map.get(sum-arr[i]) != null) {
                count += map.get(sum - arr[i]);
            }

            if (sum-arr[i] == arr[i]) {
                count--;
            }
        }

        return count/2;
    }
}
