class Solution {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Map<Integer, String> sourceMap = new HashMap<>();
        Map<Integer, String> targetMap = new HashMap<>();
        
        for (int i=0; i<indexes.length; i++) {
            sourceMap.put(indexes[i], sources[i]);
            targetMap.put(indexes[i], targets[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<S.length(); i++) {
            if (sourceMap.containsKey(i) && S.substring(i).startsWith(sourceMap.get(i))) {
                sb.append(targetMap.get(i));
                i += sourceMap.get(i).length() - 1;
            }
            else {
                sb.append(S.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
