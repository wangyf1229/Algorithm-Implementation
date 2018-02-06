class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;

        //topological sorting(BFS)
        int[] indegree = new int[numCourses];
        int res = numCourses;
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
            int pre = queue.poll();
            res--;
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == pre) {
                    int aft = prerequisites[i][0];
                    indegree[aft]--;
                    if (indegree[aft] == 0) {
                        queue.offer(aft);
                    }
                }
            }

        }

        return res == 0;
    }
}