class Solution {
  public int numSquarefulPerms(int[] nums) {
    Arrays.sort(nums);
    int[] count = {0};
    backtrack(new ArrayList<>(), nums, new boolean[nums.length], -1, count);
    return count[0];
  }
  
  private void backtrack(List<Integer> temp, int[] nums, boolean[] used, int lastNumber, int[] count) {
    if (temp.size() == nums.length){
      count[0]++;
      return;
    }
    for (int i = 0; i < nums.length; i++){
      if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])){
        continue;
      }
      if (lastNumber != -1) {
        if (!isSquare(nums[i] + lastNumber)) {
          continue;
        }
      }
      used[i] = true;
      temp.add(nums[i]);
      backtrack(temp, nums, used, nums[i], count);
      temp.remove(temp.size() - 1);
      used[i] = false;
    }
  }
  
  private boolean isSquare(int num) {
    int squareRoot = (int) Math.sqrt(num);
    return squareRoot * squareRoot == num;
  }
}
