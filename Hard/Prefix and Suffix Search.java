class WordFilter {

    Map<String, Integer> wordWeight;
    Node root;
    public WordFilter(String[] words) {
        wordWeight = new HashMap<>();
        root = new Node("");
        for (int i=0; i<words.length; i++) {
            wordWeight.put(words[i], i);
            insertWord(words[i]);
        }
    }

    private void insertWord(String word) {
        Node curr = root;
        for (int i=0; i<word.length(); i++) {
            if (!curr.childrens.containsKey(word.charAt(i))) {
                Node temp = new Node(word.substring(0, i+1));
                curr.childrens.put(word.charAt(i), temp);
            }

            curr = curr.childrens.get(word.charAt(i));

            if (i == (word.length() - 1)) {
                curr.isWord = true;
            }
        }
    }

    public int f(String prefix, String suffix) {
        List<String> words = getWords(prefix);
        int idx = -1;
        int maxWeight = Integer.MIN_VALUE;

        for (String word : words) {
            if (word.endsWith(suffix)) {
                if (wordWeight.get(word) > maxWeight) {
                    maxWeight = wordWeight.get(word);
                    idx = wordWeight.get(word);
                }
            }
        }

        return idx;
    }

    private List<String> getWords(String prefix) {
        List<String> words = new ArrayList<>();
        Node curr = root;
        for (int i=0; i<prefix.length(); i++) {
            if (curr.childrens.containsKey(prefix.charAt(i))) {
                curr = curr.childrens.get(prefix.charAt(i));
            }
            else {
                return words;
            }
        }

        findAllChildWords(words, curr);

        return words;
    }

    private void findAllChildWords(List<String> words, Node curr) {
        if (curr.isWord) {
            words.add(curr.prefix);
        }

        for (char c : curr.childrens.keySet()) {
            findAllChildWords(words, curr.childrens.get(c));
        }
    }

    class Node {
        String prefix;
        Map<Character, Node> childrens;
        boolean isWord = false;

        public Node(String prefix) {
            this.prefix = prefix;
            childrens = new HashMap<>();
        }
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
