//Trie
class Solution {
    private class TrieNode {
        boolean isWord;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public TrieNode addWords (List<String> dict) {
        TrieNode root = new TrieNode();
        for (String str : dict) {
            TrieNode r = root;
            char[] array = str.toCharArray();
            for (int i = 0; i < array.length; i++) {
                int num = array[i] - 'a';
                if (r.children[num] == null) {
                    r.children[num] = new TrieNode();
                }
                r = r.children[num];
            }
            r.isWord = true;
        }
        return root;
    }

    public String findWord(String word, TrieNode root) {
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num = array[i] - 'a';
            if (root.children[num] == null) {
                return word;
            } else if (root.children[num].isWord) {
                return word.substring(0, i+1);
            }
            root = root.children[num];
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0) return sentence;
        TrieNode root = addWords(dict);
        String[] parts = sentence.split(" ");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = findWord(parts[i], root);

        }
        return String.join(" ", parts);
    }
}

//Prefix Hash
class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.length() == 0) return sentence;
        Set<String> set = new HashSet<>(dict);
        String[] parts = sentence.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String word = parts[i];
            for (int j = 0; j < word.length(); j++) {
                if (set.contains(word.substring(0, j + 1))) {
                    parts[i] = word.substring(0, j + 1);
                    break;
                }
            }
        }
        String res = "";
        for (int i = 0; i < parts.length; i++) {
            res = res + parts[i] + " ";
        }
        return res.trim();
    }
}