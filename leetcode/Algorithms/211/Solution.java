class WordDictionary {

    Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node n = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (n.nexts[index] == null) n.nexts[index] = new Node();
            n = n.nexts[index];
        }
        n.cnt++;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (node == null) return false;
        if (index >= word.length()) return node.cnt > 0;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (search(node.nexts[i], word, index+1)) return true;
            }
        } else return search(node.nexts[word.charAt(index)-'a'], word, index+1);
        return false;
    }

    static class Node {
        int cnt;
        Node[] nexts;
        Node() {
            this.cnt = 0;
            this.nexts = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
