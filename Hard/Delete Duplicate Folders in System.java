class Solution {
    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        for (List<String> path : paths) {
            TrieNode node = root;
            for (String dir : path) {
                if (!node.children.containsKey(dir)) {
                    node.children.put(dir, new TrieNode());
                }
                node = node.children.get(dir);
            }
        }
        Map<String, Integer> frequencyMap = new HashMap<>();
        construct(root, frequencyMap);
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        operate(root, frequencyMap, result, path);
        return result;
    }

    private void construct(TrieNode root, Map<String, Integer> frequencyMap) {
        if (root.children.isEmpty()) {
            return;
        }
        List<String> serialized = new ArrayList<>();
        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            construct(entry.getValue(), frequencyMap);
            serialized.add(entry.getKey() + "(" + entry.getValue().serialized + ")");
        }
        serialized.sort(String::compareTo);
        StringBuilder sb = new StringBuilder();
        for (String s : serialized) {
            sb.append(s);
        }
        root.serialized = sb.toString();
        frequencyMap.put(root.serialized, frequencyMap.getOrDefault(root.serialized, 0) + 1);
    }

    private void operate(TrieNode root, Map<String, Integer> frequencyMap, List<List<String>> result, List<String> path) {
        if (frequencyMap.getOrDefault(root.serialized, 0) > 1) {
            return;
        }
        if (!path.isEmpty()) {
            result.add(new ArrayList<>(path));
        }
        for (Map.Entry<String, TrieNode> entry : root.children.entrySet()) {
            path.add(entry.getKey());
            operate(entry.getValue(), frequencyMap, result, path);
            path.removeLast();
        }
    }

    static class TrieNode {
        final Map<String, TrieNode> children;
        String serialized;

        public TrieNode() {
            children = new HashMap<>();
        }
    }
}
