class NumberContainers {

    private final Map<Integer, TreeSet<Integer>> numberToIndex;
    private final Map<Integer, Integer> indexToNumber;

    public NumberContainers() {
        this.numberToIndex = new HashMap<>();  
        this.indexToNumber = new HashMap<>();      
    }
    
    public void change(int index, int number) {
        if (indexToNumber.containsKey(index)) {
            int prevNumber = indexToNumber.get(index);
            numberToIndex.get(prevNumber).remove(index);
        }
        indexToNumber.put(index, number);
        numberToIndex.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }
    
    public int find(int number) {
        TreeSet<Integer> indices = numberToIndex.getOrDefault(number, new TreeSet<>());
        if (indices.isEmpty()) {
            return -1;
        }
        return indices.first();
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
