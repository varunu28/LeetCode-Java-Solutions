class Solution {
  public List<Integer> majorityElement(int[] nums) {
    Integer majorityElementOne = null;
    Integer majorityElementTwo = null;
    int countOne = 0;
    int countTwo = 0;
    for (int num : nums) {
      if (majorityElementOne != null && num == majorityElementOne) {
        countOne++;
      } else if (majorityElementTwo != null && num == majorityElementTwo) {
        countTwo++;
      } else if (countOne == 0) {
        majorityElementOne = num;
        countOne = 1;
      } else if (countTwo == 0) {
        majorityElementTwo = num;
        countTwo = 1;
      } else {
        countOne--;
        countTwo--;
      }
    }
    List<Integer> result = new ArrayList<>();
    countOne = 0;
    countTwo = 0;
    for (int num : nums) {
      if (majorityElementOne != null && majorityElementOne == num) {
        countOne++;
      }
      if (majorityElementTwo != null && majorityElementTwo == num) {
        countTwo++;
      }
    }
    if (countOne > nums.length / 3) {
      result.add(majorityElementOne);
    }
    if (countTwo > nums.length / 3) {
      result.add(majorityElementTwo);
    }
    return result;
  }
}
