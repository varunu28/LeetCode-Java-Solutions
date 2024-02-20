class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNodeManager nodeManager = new TrieNodeManager();
        for (int num : arr1) {
            nodeManager.index(String.valueOf(num));
        }
        int maxLength = 0;
        for (int num : arr2) {
            int length = nodeManager.find(String.valueOf(num));
            maxLength = Math.max(maxLength, length);
        }
        return maxLength;
    }
    
    private static class TrieNodeManager {
        
        private Node root;
        
        public TrieNodeManager() {
            this.root = new Node();
        }
        
        public void index(String s) {
            Node curr = root;
            for (char c : s.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new Node());
                }
                curr = curr.children.get(c);
            }
        }
        
        public int find(String s) {
            Node curr = root;
            for (int i = 0; i < s.length(); i++) {
                if (!curr.children.containsKey(s.charAt(i))) {
                    return i;
                }
                curr = curr.children.get(s.charAt(i));
            }
            return s.length();
        }
        
        class Node {
            Map<Character, Node> children;
            
            public Node() {
                this.children = new HashMap<>();
            }
        }
    }
}
