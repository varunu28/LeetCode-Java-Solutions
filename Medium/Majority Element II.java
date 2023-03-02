class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer candidateOne = null;
        Integer candidateTwo = null;
        int countOne = 0;
        int countTwo = 0;
        for (int num : nums) {
            if (candidateOne != null && candidateOne == num) {
                countOne++;
            } else if (candidateTwo != null && candidateTwo == num) {
                countTwo++;
            } else if (countOne == 0) {
                candidateOne = num;
                countOne++;
            } else if (countTwo == 0) {
                candidateTwo = num;
                countTwo++;
            } else {
                countOne--;
                countTwo--;
            }
        }
        countOne = 0;
        countTwo = 0;
        for (int num : nums) {
            if (candidateOne != null && candidateOne == num) {
                countOne++;
            }
            if (candidateTwo != null && candidateTwo == num) {
                countTwo++;
            }
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        if (countOne > n / 3) {
            result.add(candidateOne);
        }
        if (countTwo > n / 3) {
            result.add(candidateTwo);
        }
        return result;
    }
}
