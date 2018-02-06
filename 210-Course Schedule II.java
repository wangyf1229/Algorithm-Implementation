class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        //topological sorting(BFS)
        int[] indegree = new int[numCourses];
        int[] res = new int[numCourses];
        int num = numCourses;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (! queue.isEmpty()) {
            int cur = queue.poll();
            res[numCourses - num] = cur;
            num--;
            for (int i = 0; i < prerequisites.length; i++) {
                if(prerequisites[i][1] == cur) {
                    int next = prerequisites[i][0];
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }
        if (num != 0) return new int[0];
        return res;
    }
}