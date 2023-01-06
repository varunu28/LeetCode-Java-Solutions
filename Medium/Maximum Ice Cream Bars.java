class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int[] costFrequency = new int[1000_01];
        for (int cost : costs) {
            costFrequency[cost]++;
        }
        int numberOfIcecreams = 0;
        for (int i = 1; i <= 1000_00 && coins >= i; i++) {
            if (costFrequency[i] > 0) {
                while (coins >= i && costFrequency[i]-- > 0) {
                    numberOfIcecreams++;
                    coins -= i;
                }
            }
        }
        return numberOfIcecreams;
    }
}
