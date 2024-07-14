class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        long sum = 0;
        int minimumEnergy = Integer.MAX_VALUE;
        for (int energy : enemyEnergies) {
            sum += energy;
            minimumEnergy = Math.min(minimumEnergy, energy);
        }
        if (currentEnergy < minimumEnergy) {
            return 0;
        }
        long totalEnergy = currentEnergy;
        totalEnergy += sum - minimumEnergy;
        return totalEnergy / minimumEnergy;
    }
}
