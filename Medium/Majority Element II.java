class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int countOne = 0;
    int countTwo = 0;
    Integer candidateOne = null;
    Integer candidateTwo = null;
    for (int num : nums) {
      if (candidateOne != null && candidateOne == num) {
        countOne++;
      }
      else if (candidateTwo != null && candidateTwo == num) {
        countTwo++;
      }
      else if (countOne == 0) {
        candidateOne = num;
        countOne = 1;
      }
      else if (countTwo == 0) {
        candidateTwo = num;
        countTwo = 1;
      }
      else {
        countOne--;
        countTwo--;
      }
    }
    List<Integer> result = new ArrayList<>();
    countOne = 0;
    countTwo = 0;
    for (int num : nums) {
      if (candidateOne != null && candidateOne == num) {
        countOne++;
      }
      else if (candidateTwo != null && candidateTwo == num) {
        countTwo++;
      }
    }
    if (countOne > nums.length / 3) {
      result.add(candidateOne);
    }
    if (countTwo > nums.length / 3) {
      result.add(candidateTwo);
    }
    return result;
  }
}
