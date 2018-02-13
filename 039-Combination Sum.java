class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return res;
        helper(candidates, target, new ArrayList<>(), res, 0);
        return res;
    }

    public void helper(int[] candidates, int target, List<Integer> cur, List<List<Integer>> res, int start) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        if (target < 0) return;
        for (int i = start; i < candidates.length; i++) {
            cur.add(candidates[i]);
            helper(candidates, target - candidates[i], cur, res, i);
            cur.remove(cur.size() - 1);
        }
        return;
    }
}