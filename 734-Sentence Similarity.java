class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
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
            if (! map.get(words1[i]).contains(words2[i])) return false;
        }
        return true;

    }
}