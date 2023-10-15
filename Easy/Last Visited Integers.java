class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        int cursor = -1;
        for (String word : words) {
            if (word.equals("prev")) {
                result.add(cursor == -1 ? -1 : numbers.get(cursor));
                cursor = cursor == -1 ? -1 : (cursor - 1);
            } else {
                numbers.add(Integer.parseInt(word));
                cursor = numbers.size() - 1;
            }
        }
        return result;
    }
}
