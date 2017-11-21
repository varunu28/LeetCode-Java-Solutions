class Solution {
    
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }

        Map<Character, Integer> sortedMap = sortByValue(map);


        StringBuilder sb = new StringBuilder("");

        for (Map.Entry<Character,Integer> entry : sortedMap.entrySet()) {
            String t = String.join("", Collections.nCopies(entry.getValue(), String.valueOf(entry.getKey())));
            sb.append(t);
        }

        return sb.toString();
    }

    private Map<Character, Integer> sortByValue(Map<Character, Integer> unsortMap) {

        List<Map.Entry<Character, Integer>> list =
                new LinkedList<Map.Entry<Character, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<Character, Integer> sortedMap = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
