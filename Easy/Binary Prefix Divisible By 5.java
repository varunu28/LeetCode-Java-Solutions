class Solution {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();

        int currSum = 0;
        for (int i = 0; i < A.length; i++) {
            currSum = 2 * currSum + A[i];
            currSum %= 5;
            list.add(currSum % 5 == 0);
        }

        return list;
    }
}
