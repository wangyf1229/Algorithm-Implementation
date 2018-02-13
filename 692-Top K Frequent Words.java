class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
                if (e1.getValue() == e2.getValue()){
                        return (e2.getKey()).compareTo(e1.getKey());
                }
                return e1.getValue() - e2.getValue();
            }
        });
        for (String word: words) {
            int time = map.getOrDefault(word, 0);
            map.put(word, time + 1);
        }
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (pq.size() >= k) {
                Map.Entry<String, Integer> temp = pq.peek();
                if (temp.getValue() < entry.getValue()) {
                    pq.poll();
                    pq.add(entry);
                } else if (temp.getValue() == entry.getValue() && (entry.getKey()).compareTo(temp.getKey()) < 0) {
                    pq.poll();
                    pq.add(entry);
                }
            } else {
                pq.add(entry);
            }
        }

        List<String> list = new ArrayList<>();
        while (! pq.isEmpty()) {
            list.add(0, pq.poll().getKey());
        }
        return list;
    }
}