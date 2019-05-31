class Solution {
    public int candy(int[] ratings) {
        if (ratings.length <= 1) {
            return ratings.length;
        }
        
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            candies[i] = 1;
        }
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            }
        }
        
        int candyCount = 0;
        for (int candy : candies) {
            candyCount += candy;
        }
        
        return candyCount;
    }
}
