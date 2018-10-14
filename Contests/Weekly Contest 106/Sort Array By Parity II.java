class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int[] odd = new int[A.length/2];
        int[] even = new int[A.length/2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (k < A.length) {
            if (A[k]%2 == 0) {
                even[j++] = A[k++];
            }
            else {
                odd[i++] = A[k++];
            }
        }
        
        i = 0;
        j = 0;
        k = 0;

        while (k < ans.length) {
            if (k%2 == 0) {
                ans[k++] = even[j++];
            }
            else {
                ans[k++] = odd[i++];
            }
        }

        return ans;
    }
}
