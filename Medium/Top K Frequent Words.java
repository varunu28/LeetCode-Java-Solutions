class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Queue<Map.Entry<String,Integer>> maxHeap =
                        new PriorityQueue<>((o1,o2)->o1.getValue() == o2.getValue() ?
                                                o1.getKey().compareTo(o2.getKey()) :
                                                    o2.getValue()-o1.getValue());

        for(Map.Entry<String,Integer> entry: map.entrySet()) {
            maxHeap.offer(entry);
        }

        List<String> topKWords = new ArrayList<>();

        while(topKWords.size() <k){
            topKWords.add(maxHeap.poll().getKey());
        }

        return topKWords;
    }
}
