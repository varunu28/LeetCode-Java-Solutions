class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<>();
        int[] copy = Arrays.copyOf(A, A.length);
        int n = A.length - 1;
        Arrays.sort(A);
        int greatest = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            int idx = findIdx(copy, A[greatest]);
            flip(copy, idx);
            ans.add(idx + 1);
            flip(copy, greatest);
            ans.add(greatest + 1);
            greatest--;
        }

        return ans;
    }

    private void flip (int[] copy, int idx) {
        int start = 0;
        int end = idx;
        while (start < end) {
            int temp = copy[start];
            copy[start] = copy[end];
            copy[end] = temp;
            start++;
            end--;
        }
    }

    private int findIdx (int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }
}
