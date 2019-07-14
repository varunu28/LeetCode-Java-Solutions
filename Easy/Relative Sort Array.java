class Solution {
    public int[] relativeSortArray(int[] A1, int[] A2) {
        Map<Integer, Integer> a2Map = new LinkedHashMap<>();
        Map<Integer, Integer> a1Map = new HashMap<>();
        int idx = 0;
        for (int num : A2) {
            if (!a2Map.containsKey(num)) {
                a2Map.put(num, idx++);
            }
        }

        for (int num : A1) {
            a1Map.put(num, a1Map.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (Integer key : a2Map.keySet()) {
            int count = a1Map.getOrDefault(key, 0);
            while (count-- > 0) {
                A1[i++] = key;
            }
            
            a1Map.remove(key);
        }

        List<Integer> leftOver = new ArrayList<>();
        for (Integer key : a1Map.keySet()) {
            int count = a1Map.get(key);
            while (count-- > 0) {
                leftOver.add(key);
            }
        }

        Collections.sort(leftOver);
        for (int num : leftOver) {
            A1[i++] = num;
        }
        
        return A1;
    }
}
