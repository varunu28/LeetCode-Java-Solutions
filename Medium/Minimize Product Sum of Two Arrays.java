class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        int[] frequencyOne = new int[101];
        int[] frequencyTwo = new int[101];
        for (int i = 0; i < nums1.length; i++) {
            frequencyOne[nums1[i]]++;
            frequencyTwo[nums2[i]]++;
        }
        int productSum = 0;
        int idxOne = 1;
        int idxTwo = 100;
        while (idxOne < 101 && idxTwo > 0) {
            if (frequencyOne[idxOne] == 0) {
                idxOne++;
            } else if (frequencyTwo[idxTwo] == 0) {
                idxTwo--;
            } else {
                productSum += idxOne * idxTwo;
                frequencyOne[idxOne]--;
                frequencyTwo[idxTwo]--;
            }
        }
        return productSum;
    }
}
