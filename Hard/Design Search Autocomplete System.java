class AutocompleteSystem {

    Node root;
    Map<String, Integer> wordWeight;
    int i;
    StringBuilder sb;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Node("");
        wordWeight = new HashMap<>();
        i = 0;
        sb = new StringBuilder();

        for (String sentence : sentences) {
            insertWord(sentence);
            wordWeight.put(sentence, times[i++]);
        }
    }

    private void insertWord(String sentence) {
        Node curr = root;
        for (int i=0; i<sentence.length(); i++) {
            if (!curr.childrens.containsKey(sentence.charAt(i))) {
                curr.childrens.put(sentence.charAt(i), new Node(sentence.substring(0, i+1)));
            }

            curr = curr.childrens.get(sentence.charAt(i));

            if (i == sentence.length()-1) {
                curr.isWord = true;
            }
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            wordWeight.put(sb.toString(), wordWeight.getOrDefault(sb.toString(), 0) + 1);
            insertWord(sb.toString());
            sb = new StringBuilder();
            return new ArrayList<>();
        }

        sb.append(c);

        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (wordWeight.get(o1) - wordWeight.get(o2) == 0) {
                    return o2.compareTo(o1);
                }
                else {
                    return wordWeight.get(o1) - wordWeight.get(o2);
                }
            }
        });

        String prefix = sb.toString();
        Node curr = root;

        for (char ch : prefix.toCharArray()) {
            if (curr.childrens.containsKey(ch)) {
                curr = curr.childrens.get(ch);
            }
            else {
                return new ArrayList<>();
            }
        }

        findAllChildWorlds(curr, pq);

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        Collections.reverse(ans);

        return ans;
    }

    private void findAllChildWorlds(Node curr, PriorityQueue<String> pq) {
        if (curr.isWord) {
            pq.add(curr.prefix);
            if (pq.size() > 3) {
                pq.poll();
            }
        }

        for (char c : curr.childrens.keySet()) {
            findAllChildWorlds(curr.childrens.get(c), pq);
        }
    }
}

class Node {
    String prefix;
    Map<Character, Node> childrens;
    boolean isWord;

    public Node(String prefix) {
        this.prefix = prefix;
        this.childrens = new HashMap<>();
    }
}
/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
