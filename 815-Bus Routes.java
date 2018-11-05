class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S == T) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>(); //Map: stop -> Bus #
        Set<Integer> visitedBuses = new HashSet<>(); //visited buses
        Set<Integer> visitedStops = new HashSet<>(); //visited stops
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) {
                    map.put(stop, new ArrayList<Integer>());
                }
                map.get(stop).add(i);
            }
        }
        queue.add(S);
        visitedStops.add(S);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                for (int bus : map.get(stop)) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);
                    int[] nextStops = routes[bus];
                    for (int nextStop : nextStops) {
                        if (nextStop == T) return step;
                        if (!visitedStops.contains(nextStop)) {
                            queue.offer(nextStop);
                            visitedStops.add(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}