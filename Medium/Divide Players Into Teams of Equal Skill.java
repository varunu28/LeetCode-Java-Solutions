class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long totalChemistry = 0;
        int start = 0;
        int end = skill.length - 1;
        int totalSkill = skill[start] + skill[end];
        while (start < end) {
            int currTotal = skill[start] + skill[end];
            if (currTotal != totalSkill) {
                return -1;
            }
            totalChemistry += skill[start] * skill[end];
            start++;
            end--;
        }
        return totalChemistry;
    }
}
