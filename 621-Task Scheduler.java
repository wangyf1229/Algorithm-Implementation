class Solution {

    //common law
    public int leastInterval(char[] tasks, int n) {
        int maxNum = 0;
        int maxCount = 0;
        char[] taskCount = new char[26];
        for (char task:tasks) {
            taskCount[task-'A']++;
            int curNum = taskCount[task - 'A'];
            if (curNum > maxNum) {
               maxCount = 1;
               maxNum = curNum;
            } else if (curNum == maxNum) {
                maxCount++;
            }
        }
        
        int slotNum = maxNum - 1;
        int availableSpotsPerSlot = n - maxCount + 1;
        int availableSpots = slotNum * availableSpotsPerSlot;
        
        int remainingTasks = tasks.length - maxCount * maxNum;
        
        int idles = availableSpots > remainingTasks ? availableSpots - remainingTasks : 0;
        return tasks.length + idles;
    }

    //general method
    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tasks) {
            int number = map.getOrDefault(c, 0);
            map.put(c, number + 1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());
        
        int count = 0;
        int remainingTasks = tasks.length;
        while(!pq.isEmpty()) {
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                Map.Entry<Character, Integer> e = pq.poll();
                if (remainingTasks <= 0) break;
                if (e == null) {
                    count++;
                } else {
                    remainingTasks--;
                    count++;
                    int number = e.getValue();
                    if (number > 1) {
                        e.setValue(number - 1);
                        list.add(e);
                    }
                }
            }
            pq.addAll(list);
        }
        return count;     
    }
}