class Solution {
  public int primePalindrome(int N) {
    for (int i = 1; i <= 5; i++) {
      for (int root = (int)Math.pow(10, i - 1); root < (int)Math.pow(10, i); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int j = i - 2; j >= 0; j--) {
          sb.append(sb.charAt(j));
        }
        int num = Integer.valueOf(sb.toString());
        if (num >= N && isPrime(num)) {
          return num;
        }
      }
      for (int root = (int)Math.pow(10, i - 1); root < (int)Math.pow(10, i); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int j = i - 1; j >= 0; j--) {
          sb.append(sb.charAt(j));
        }
        int num = Integer.parseInt(sb.toString());
        if (num >= N && isPrime(num)) {
          return num;
        }
      }
    }
    return -1;
  }
  
  private boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int j = 2; j <= (int) Math.sqrt(n); j++) {
      if (n % j == 0) {
        return false;
      }
    }
    return true;
  }
}
