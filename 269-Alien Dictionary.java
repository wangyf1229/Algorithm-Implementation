class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            char[] array = words[i].toCharArray();
            for (char c : array) {
                if (!map.containsKey(c)) map.put(c, new HashSet<Character>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    map.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }
        
        for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() == 0) queue.offer(entry.getKey());
        }
        
        while (!queue.isEmpty()) {
            char c = queue.poll();
            map.remove(c);
            sb.append(c);
            for (Map.Entry<Character, Set<Character>> entry : map.entrySet()) {
                Set<Character> set = entry.getValue();
                if (set.contains(c)) {
                    set.remove(c);
                    //Pay special attention here! It is the same as course schedule. 
                    //I cannot put the if-clause outsite the loop which means after I deduct the indegree by 1
                    //and scan all the entries again and add all the keys whose indegree are 0.
                    //Because I haven't ruled out other elements in the queue whose indegree are 0. 
                    //So if I put the if-clause outsite the for loop, I may add same element again in the queue.
                    //See wrong answer before.
                    if (set.size() == 0) queue.offer(entry.getKey());
                }
            }
        }
        
        if (!map.isEmpty()) return "";
        return sb.toString();
        
    }
}