class FrequencyTracker {

    private final Map<Integer, Integer> numToFrequencyMapping;
    private final Map<Integer, Set<Integer>> frequencyToNumMapping;

    public FrequencyTracker() {
        this.numToFrequencyMapping = new HashMap<>();
        this.frequencyToNumMapping = new HashMap<>();
    }

    public void add(int number) {
        int prevFrequency = this.numToFrequencyMapping.getOrDefault(number, 0);
        int newFrequency = prevFrequency + 1;
        this.numToFrequencyMapping.put(number, newFrequency);
        updateFreqToNumMapping(number, prevFrequency, newFrequency);
    }

    public void deleteOne(int number) {
        int prevFrequency = this.numToFrequencyMapping.getOrDefault(number, 0);
        if (prevFrequency == 0) {
            return;
        }
        int newFrequency = prevFrequency - 1;
        this.numToFrequencyMapping.put(number, newFrequency);
        updateFreqToNumMapping(number, prevFrequency, newFrequency);
    }

    public boolean hasFrequency(int frequency) {
        return this.frequencyToNumMapping.getOrDefault(frequency, new HashSet<>()).size() > 0;
    }

    private void updateFreqToNumMapping(int number, int prevFrequency, int newFrequency) {
        if (prevFrequency != 0) {
            this.frequencyToNumMapping.get(prevFrequency).remove(number);
        }
        if (newFrequency != 0) {
            this.frequencyToNumMapping.computeIfAbsent(newFrequency, k -> new HashSet<>()).add(number);
        }
    }
}

/**
 * Your FrequencyTracker object will be instantiated and called as such:
 * FrequencyTracker obj = new FrequencyTracker();
 * obj.add(number);
 * obj.deleteOne(number);
 * boolean param_3 = obj.hasFrequency(frequency);
 */
