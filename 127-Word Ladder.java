class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //BFS
        if (wordList == null) return 0;
        if (! wordList.contains(endWord)) return 0;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> wordVisited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int length = 1;
        int size = 1;
        wordVisited.add(beginWord);
        while (! queue.isEmpty()) {
            for (int i = 0; i < size; i++) {
                String candidate = queue.poll();

                //Add another candidate to the queue
                for (int j = 0; j < candidate.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char[] cArray = candidate.toCharArray();
                        if (cArray[j] != c) {
                            cArray[j] = c;
                            String newCan = new String(cArray);
                            if (newCan.equals(endWord)) {
                                return (length + 1);
                            }
                            if (dict.contains(newCan)) {
                                dict.remove(newCan);
                                queue.offer(newCan);
                            }
                        }
                    }
                }
            }
            length++;
            size = queue.size();
        }
        return 0;
    }
}