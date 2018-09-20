class Solution {
    public static String[] uncommonFromSentences(String A, String B) {
        Map<String, Long> map = Arrays.
                                    stream((A + " " + B).
                                    split("\\s+")).
                                    collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> uncommon = map.
                                    entrySet().
                                    stream().
                                    filter(e -> e.getValue() == 1).
                                    map(e -> e.getKey()).
                                    collect(Collectors.toList());

        String[] ans = new String[uncommon.size()];

        return uncommon.toArray(ans);
    }
}
