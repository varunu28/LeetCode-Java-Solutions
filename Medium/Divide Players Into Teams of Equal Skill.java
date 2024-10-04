class Solution {
    public long dividePlayers(int[] skill) {
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int s : skill) {
            totalSkill += s;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        if (totalSkill % (n / 2) != 0) {
            return -1;
        }
        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;
        for (int currSkill : map.keySet()) {
            int partnerSkill = targetSkill - currSkill;
            int currSkillFreq = map.get(currSkill);
            if (!map.containsKey(partnerSkill) || currSkillFreq != map.get(partnerSkill)) {
                return -1;
            }
            totalChemistry += (long) currSkill * (long) partnerSkill * (long) currSkillFreq;
        }
        return totalChemistry / 2;
    }
}
