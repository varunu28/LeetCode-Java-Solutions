class Solution {
    public long[] maximumCoins(int[] heroes, int[] monsters, int[] coins) {
        List<MonsterEntity> monsterEntities = new ArrayList<>();
        int n = monsters.length;
        for (int i = 0; i < n; i++) {
            monsterEntities.add(new MonsterEntity(monsters[i], coins[i]));
        }
        Collections.sort(monsterEntities, (a, b) -> (a.health() - b.health()));
        long[] prefixCoinSum = new long[n];
        for (int i = 0; i < n; i++) {
            prefixCoinSum[i] = i == 0 ? 0 : prefixCoinSum[i - 1];
            prefixCoinSum[i] += monsterEntities.get(i).coin();
        }
        int m = heroes.length;
        long[] result = new long[m];
        for (int i = 0; i < m; i++) {
            int idx = binarySearch(monsterEntities, heroes[i]);
            result[i] = idx != Integer.MIN_VALUE ? prefixCoinSum[idx] : 0;
        }
        return result;
    }

    private int binarySearch(List<MonsterEntity> monsterEntities, int heroHealth) {
        int left = 0;
        int right = monsterEntities.size() - 1;
        int idx = Integer.MIN_VALUE;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (monsterEntities.get(mid).health() <= heroHealth) {
                idx = Math.max(idx, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

    private static record MonsterEntity(int health, int coin) {}
}
