class Solution {  
  public int thirdMax(int[] nums) {
    final double BASE_VALUE = ((double) Integer.MIN_VALUE) - 1;
    double firstMax = BASE_VALUE;
    double secMax = BASE_VALUE;
    double thirdMax = BASE_VALUE;
    for (int num : nums) {
      if (num > firstMax) {
        thirdMax = secMax;
        secMax = firstMax;
        firstMax = num;
      }
      else if (num > secMax && num < firstMax) {
        thirdMax = secMax;
        secMax = num;
      }
      else if (num > thirdMax && num < firstMax && num < secMax) {
        thirdMax = num;
      }
    }
    return thirdMax == BASE_VALUE ? (int) firstMax : (int) thirdMax;
  }
}
