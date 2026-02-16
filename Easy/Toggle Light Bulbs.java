class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        Map<Integer, Boolean> bulbState = new HashMap<>();
        for (Integer bulb : bulbs) {
            boolean currentState = bulbState.getOrDefault(bulb, false);
            boolean newState = !currentState;
            bulbState.put(bulb, newState);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            if (bulbState.getOrDefault(i, false)) {
                result.add(i);
            }
        }
        return result;
    }
}
