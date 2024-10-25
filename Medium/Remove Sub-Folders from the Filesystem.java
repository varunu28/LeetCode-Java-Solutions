class Solution {
    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode();
        for (String file : folder) {
            TrieNode curr = root;
            String[] splits = file.split("/");
            for (int i = 1; i < splits.length; i++) {
                Optional<TrieNode> nextNode = curr.getChild(splits[i]);
                if (nextNode.isEmpty()) {
                    TrieNode newNode = curr.addChild(splits[i]);
                    curr = newNode;
                } else {
                    curr = nextNode.get();
                }
            }
            curr.markIsFolder();
        }
        List<String> result = new ArrayList<>();
        for (String file : folder) {
            TrieNode curr = root;
            String[] splits = file.split("/");
            boolean isSubfolder = false;
            for (int i = 1; i < splits.length; i++) {
                TrieNode nextNode = curr.getChild(splits[i]).get();
                if (nextNode.isFolder() && i != splits.length - 1) {
                    isSubfolder = true;
                    break;
                }
                curr = nextNode;
            }
            if (!isSubfolder) {
                result.add(file);
            }
        }
        return result;
    }

    class TrieNode {
        private boolean isFolder;
        private Map<String, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public TrieNode addChild(String childKey) {
            TrieNode node = new TrieNode();
            children.put(childKey, node);
            return node;
        }

        public Optional<TrieNode> getChild(String childKey) {
            if (!children.containsKey(childKey)) {
                return Optional.empty();
            }
            return Optional.of(children.get(childKey));
        }

        public void markIsFolder() {
            isFolder = true;
        }

        public boolean isFolder() {
            return isFolder;
        }
    }
}
