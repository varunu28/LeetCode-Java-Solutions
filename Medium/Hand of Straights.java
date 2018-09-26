class Solution {
    public static boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W != 0) {
            return false;
        }

        Map<Integer, Integer> map = new TreeMap<>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Set<Integer> keys;
        int batches = hand.length/W;
        int batchSize;

        while (batches-- > 0) {
            keys = map.keySet();
            Iterator<Integer> iterator = keys.iterator();
            batchSize = W;
            int val = iterator.next();

            while (batchSize-- > 0) {
                if (map.containsKey(val)) {
                    if (map.get(val) == 1) {
                        map.remove(val);
                    }
                    else {
                        map.put(val, map.getOrDefault(val, 0)-1);
                    }
                    val++;
                }
                else {
                    return false;
                }
            }
        }

        return true;
    }
}
