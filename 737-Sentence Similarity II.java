class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < pairs.length; i++) {
            Set<String> set = map.getOrDefault(pairs[i][0], new HashSet<String>());
            set.add(pairs[i][1]);
            map.put(pairs[i][0], set);
            Set<String> set2 = map.getOrDefault(pairs[i][1], new HashSet<String>());
            set2.add(pairs[i][0]);
            map.put(pairs[i][1], set2);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words2[i].equals(words1[i])) continue;
            if (! map.containsKey(words1[i])) return false;
            if (!dfs(map, words1[i], words2[i], new HashSet<String>())) return false;
        }
        return true;
    }

    public boolean dfs(Map<String, Set<String>> map, String word1, String word2, Set<String> visited) {
        Set<String> set = map.get(word1);
        visited.add(word1);
        for (String str: set) {
            if (word2.equals(str)) return true;
            if (map.containsKey(str) && !visited.contains(str)) {
                if (dfs(map, str, word2, visited)) return true;
            }
        }
        return false;
    }
}

//Union-Find
class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1 == null || words2 == null) return false;
        if (words1.length != words2.length) return false;
        Map<String, String> map = new HashMap<>();
        for (String[] pair: pairs) {
            String word1 = find(map, pair[0]);
            String word2 = find(map, pair[1]);
            map.put(word1, word2);
        }
        for (int i = 0; i < words1.length; i++) {
            if (words2[i].equals(words1[i])) continue;
            if (! map.containsKey(words1[i])) return false;
            if (! (find(map, words1[i])).equals(find(map, words2[i]))) return false;
        }
        return true;
    }

    public String find (Map<String, String> map, String word) {
        if (! map.containsKey(word)) map.put(word, word);
        if (map.get(word).equals(word)) return word;
        return find(map, map.get(word));
    }
}