class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 0;
        int size = 1;
        while (! queue.isEmpty()) {
            level++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                List<String> list = addNextWords(word, dict);
                for (String next: list) {
                    queue.add(next);
                }
            }
            size = queue.size();
        }
        return 0;
    }

    public List<String> addNextWords(String word, Set<String> dict) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] arr = word.toCharArray();
            for (int j = 0; j < 26; j++) {
                if (arr[i] - 'a' == j) continue;
                arr[i] = (char) ((int)'a' + j);
                String temp = new String(arr);
                if (dict.contains(temp)) {
                    list.add(temp);
                    dict.remove(temp);
                }
            }
        }
        return list;

    }
}