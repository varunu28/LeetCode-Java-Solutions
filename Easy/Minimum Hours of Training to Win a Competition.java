class Solution {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    int totalEnergy = 0;
    int experienceDeficit = 0;
    for (int i = 0; i < energy.length; i++) {
      totalEnergy += energy[i];
      if (initialExperience <= experience[i]) {
        experienceDeficit += experience[i] - initialExperience + 1;
        initialExperience = experience[i] + 1;
      }
      initialExperience += experience[i];
    }
    return experienceDeficit + (totalEnergy >= initialEnergy ? totalEnergy - initialEnergy + 1 : 0);
  }
}
