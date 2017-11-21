class Solution {
    
    public String replaceWords(List<String> dict, String sentence) {

        Map<String, Integer> map = new HashMap<>();

        for (String s: dict) {
            map.put(s, s.length());
        }

        Map<String, Integer> sortedMap = sortByValue(map);

        String[] arr = sentence.split("\\s");
        String[] ans = new String[arr.length];
        int j = 0;

        for (String s : arr) {
            boolean gotIt = false;
            for (Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
                if (s.startsWith(entry.getKey())) {
                    ans[j] = entry.getKey();
                    gotIt = true;
                    break;
                }
            }

            if (!gotIt) {
                ans[j] = s;
            }

            j++;
        }

        StringBuilder ansString = new StringBuilder("");

        for (String s : ans) {
            ansString.append(s + " ");
        }

        return ansString.toString().trim();
    }

    private Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

        List<Map.Entry<String, Integer>> list =
                new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

}
