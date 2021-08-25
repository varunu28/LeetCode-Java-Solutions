import java.math.BigInteger;


class Solution {
  public int findGCD(int[] nums) {
    return BigInteger.valueOf(Arrays.stream(nums).max().orElse(1))
        .gcd(BigInteger.valueOf(Arrays.stream(nums).min().orElse(1))).intValue();
  }
}
