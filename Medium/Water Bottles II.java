class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = numBottles;
        while (numBottles >= numExchange) {
            numBottles -= numExchange;
            numExchange++;
            total++;
            numBottles++;
        }
        return total;
    }
}
