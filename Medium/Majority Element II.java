class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int count1 = 0;
    int count2 = 0;
    Integer candidate1 = null;
    Integer candidate2 = null;
    for (int num : nums) {
      if (candidate1 != null && candidate1 == num) {
        count1++; 
      }
      else if (candidate2 != null && candidate2 == num) {
        count2++;
      }
      else if (count1 == 0) {
        candidate1 = num;
        count1 = 1;
      }
      else if (count2 == 0) {
        candidate2 = num;
        count2 = 1;
      }
      else {
        count1--;
        count2--;
      }
    }
    List<Integer> ans = new ArrayList<>();
    count1 = 0;
    count2 = 0;
    for (int num : nums) {
      if (candidate1 != null && candidate1 == num) {
        count1++;
      }
      else if (candidate2 != null && candidate2 == num) {
        count2++;
      }
    }
    if (count1 > nums.length / 3) {
      ans.add(candidate1);
    }
    if (count2 > nums.length / 3) {
      ans.add(candidate2);
    }
    return ans;
  }
}
