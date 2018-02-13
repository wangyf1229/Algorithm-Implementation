class RandomizedSet {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (! map.containsKey(val)) return false;
        int num = map.get(val);
        map.remove(val);
        int last_value = list.get(list.size() - 1);
        list.set(num, last_value);
        list.remove(list.size() - 1);
        if (last_value != val) {
            map.put(last_value, num);
        }
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (list.size() == 1) return list.get(0);
        int randomNum = rand.nextInt(list.size());
        return list.get(randomNum);

    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */