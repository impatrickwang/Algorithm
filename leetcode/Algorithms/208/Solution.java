class Trie {

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node(' '); 
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            if (!n.mapping.containsKey(word.charAt(i))) n.mapping.put(word.charAt(i), new Node(word.charAt(i)));
            n = n.mapping.get(word.charAt(i));
        }
        n.cnt ++;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node n = searchNode(word);
        return n != null && n.cnt > 0;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null; 
    }

    private Node searchNode(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            if (!n.mapping.containsKey(word.charAt(i))) return null;
            n = n.mapping.get(word.charAt(i));
        }
        return n;
    }

    static class Node {
        char c;
        Map<Character, Node> mapping;
        int cnt;
        Node(char c) {
            this.c = c;
            this.mapping = new HashMap<Character, Node>();
            this.cnt = 0;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
