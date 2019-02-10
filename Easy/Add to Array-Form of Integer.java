class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        int[] kArr = getArray(K);
        int len1 = A.length - 1;
        int len2 = kArr.length - 1;
        int carry = 0;

        List<Integer> list = new ArrayList<>();

        while (len1 >= 0 || len2 >= 0) {
            int temp = 0;

            if (len1 >= 0 && len2 >= 0) {
                temp = A[len1] + kArr[len2] + carry;
                len1--;
                len2--;
            }
            else if (len1 >= 0 && len2 < 0) {
                temp = A[len1] + carry;
                len1--;
            }
            else {
                temp = kArr[len2] + carry;
                len2--;
            }

            if (temp > 9) {
                carry = temp / 10;
                temp %= 10;
            }
            else {
                carry = 0;
            }

            list.add(temp);
        }

        if (carry > 0) {
            list.add(carry);
        }

        Collections.reverse(list);

        return list;
    }

    private int[] getArray(int k) {
        int len = String.valueOf(k).length();
        int[] ans = new int[len];

        for (int i=len-1; i>=0; i--) {
            ans[i] = k % 10;
            k /= 10;
        }

        return ans;
    }
}
