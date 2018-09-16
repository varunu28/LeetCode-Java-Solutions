class Solution {
    public static int[] sortArrayByParity(int[] A) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();


        for (int num : A) {
            if (num%2 == 0) {
                even.add(num);
            }
            else {
                odd.add(num);
            }
        }

        int i = 0;

        for (int num : even) {
            A[i++] = num;
        }

        for (int num : odd) {
            A[i++] = num;
        }

        return A;
    }
}
