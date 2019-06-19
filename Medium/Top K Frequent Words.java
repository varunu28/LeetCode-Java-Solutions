class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>(){
            public int compare(String s1, String s2) {
                int c = map.get(s2).compareTo(map.get(s1));
                if (c != 0) {
                    return c;
                }
                
                return s1.compareTo(s2);
            } 
        });
        
        for (String key : map.keySet()) {
            pq.add(key);
        }
        
        List<String> list = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            list.add(pq.poll());
        }
        
        return list;
    }
}
