class Trie {
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode () {
            children = new TrieNode[26];
            isWord = false;
            word = "";
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode root = this.root;
        for (int i = 0; i < word.length(); i++) {
            int num = word.charAt(i) - 'a';
            if (root.children[num] == null) {
                root.children[num] = new TrieNode();
            }
            root = root.children[num];
        }
        root.isWord = true;
        root.word = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startWithHelper(root, prefix, 0);
    }

    public boolean searchHelper(TrieNode root, String word, int index) {
        TrieNode trieNow = root.children[word.charAt(index)-'a'];
        if (index + 1 == word.length()) return ((trieNow != null) && trieNow.isWord);
        if (trieNow == null) return false;
        return searchHelper(trieNow, word, index + 1);
    }

    public boolean startWithHelper(TrieNode root, String word, int index) {
        TrieNode trieNow = root.children[word.charAt(index)-'a'];
        if (index + 1 == word.length()) return (trieNow != null);
        if (trieNow == null) return false;
        return startWithHelper(trieNow, word, index + 1);
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */