class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (canPlaceCheck(i, flowerbed)) {
                flowerbed[i] = 1;
                n--;
            } 
        }
        return n == 0;
    }
    
    private boolean canPlaceCheck(int i, int[] flowerbed) {
        return flowerbed[i] == 0 && (
            (i == 0 && (i + 1 == flowerbed.length || flowerbed[i + 1] == 0)) || 
            (i == flowerbed.length - 1 && (i - 1 == -1 || flowerbed[i - 1] == 0)) || 
            (i != 0 && i != flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0)
        );
    }
}
