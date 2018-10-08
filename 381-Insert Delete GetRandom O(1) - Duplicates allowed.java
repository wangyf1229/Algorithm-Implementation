class RandomizedCollection {
    
    List<Integer> list;
    Map<Integer, Set<Integer>> map;
    Random random;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean isNotContained = true;
        list.add(val);
        if (map.containsKey(val)) isNotContained = false;
        Set<Integer> set = map.getOrDefault(val, new HashSet<>());
        set.add(list.size() - 1);
        map.put(val, set);
        return isNotContained;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        //special cases: 1. there is only one element in the list
        //               2. the last element in the list is equal to the removed value
        //In fact they are the same condition
        if (!map.containsKey(val)) return false;
        
        Set<Integer> set = map.get(val);
        if (list.get(list.size() - 1) == val) {
            set.remove(list.size() - 1);
            list.remove(list.size() - 1);
        } else {
            int idx = set.iterator().next();
            set.remove(idx);
            int last = list.get(list.size() - 1);
            list.set(idx, last);
            Set<Integer> setLast = map.get(last);
            setLast.remove(list.size() - 1);
            setLast.add(idx);
            map.put(last, setLast);
            list.remove(list.size() - 1);
        }
        
        if (set.size() == 0) {
            map.remove(val);
        } else {
            map.put(val, set);
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int rnd = random.nextInt(list.size());
        return list.get(rnd);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */