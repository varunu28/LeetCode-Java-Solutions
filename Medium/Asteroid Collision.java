class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        while (idx < asteroids.length && asteroids[idx] < 0) {
            result.add(asteroids[idx++]);
        }
        while (idx < asteroids.length) {
            if (asteroids[idx] > 0) {
                result.add(asteroids[idx++]);
            } else {
                if (result.isEmpty() || result.get(result.size() - 1) < 0) {
                    result.add(asteroids[idx]);
                } else {
                    while (!result.isEmpty() && 
                           result.get(result.size() - 1) > 0 && 
                           result.get(result.size() - 1) < Math.abs(asteroids[idx])) {
                        result.remove(result.size() - 1);
                    }
                    if (!result.isEmpty() && result.get(result.size() - 1) > 0) {
                        if (result.get(result.size() - 1) == Math.abs(asteroids[idx])) {
                            result.remove(result.size() - 1);
                        } 
                    } else {
                        result.add(asteroids[idx]);
                    }
                }
                idx++;
            }
        }
        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
