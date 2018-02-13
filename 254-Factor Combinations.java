class Solution {
    public List<List<Integer>> getFactors(int n) {
        return helper(n, 2);
    }

    public List<List<Integer>> helper(int m, int start) {
        if (m <= 1) return new ArrayList<List<Integer>>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0 && i >= start) {
                List<List<Integer>> temp = helper(m/i, i);
                for (List<Integer> list_temp: temp) {
                    List<Integer> res = new ArrayList<>();
                    res.add(i);
                    res.addAll(list_temp);
                    list.add(res);
                }
                list.add(new ArrayList<Integer>(Arrays.asList(i, m/i)));
            }
        }
        return list;
    }
}