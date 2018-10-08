class Solution {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length == 0) return false;
        //the set at index i means the # units the frog is able to jump from current units
        //stone location -> set
        Map<Integer, Set<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<Integer>());
        }
        map.get(stones[0]).add(1);
        for (int i = 0; i < stones.length; i++) {
            for (int step : map.get(stones[i])) {
                //step != 0 because if step == 0, you cannot iterate the set and add elements to the set at the same time 
                if (step != 0 && map.containsKey(stones[i] + step)) {
                    for (int k = step - 1; k <= step + 1; k++) {
                        map.get(stones[i] + step).add(k);
                    }
                }
            }
        }
        return (!map.get(stones[stones.length - 1]).isEmpty());
    }
}