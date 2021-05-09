class Solution {
  public int maximumPopulation(int[][] logs) {
    int[] population = new int[2051];
    for (int[] log : logs) {
      population[log[0]]++;
      population[log[1]]--;
    }
    int maxPopulationYear = 0;
    for (int i = 1950; i <= 2050; i++) {
      population[i] += population[i - 1];
      maxPopulationYear = population[i] > population[maxPopulationYear] ? i : maxPopulationYear;
    }
    return maxPopulationYear;
  }
}
