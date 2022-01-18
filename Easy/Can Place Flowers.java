class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length && n > 0; i++) {
      if (flowerbed[i] == 0) {
        if (i == 0 && (i + 1 < flowerbed.length && flowerbed[i + 1] == 0)
            || flowerbed.length == 1) {
          flowerbed[i] = 1;
          n--;
        } else if (i == flowerbed.length - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0) {
          flowerbed[i] = 1;
          n--;
        } else if (i + 1 < flowerbed.length && i - 1 >= 0 && flowerbed[i + 1] == 0
            && flowerbed[i - 1] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      }
    }
    return n == 0;
  }
}
