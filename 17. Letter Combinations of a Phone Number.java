class Solution {
    String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    //for loop (Special solution)
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        res.add("");
        while(res.peek().length() < digits.length()) {
            String str = res.poll();
            String map = mapping[digits.charAt(str.length()) - '0'];
            for (int i = 0; i < map.length(); i++) {
                res.add(str + map.charAt(i));
            }
        }
        return res;
    }

    //backtracking
    public List<String> letterCombinations2(String digits) {
        List<String> res = new ArrayList<String>();
        if (digits == null || digits.length() == 0) return res;
        helper(digits, res, "", 0);
        return res;
    }

    public void helper(String digits, List<String> res, String s, int index) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        String str = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            helper(digits, res, s + str.charAt(i), index + 1);
        }
        return;
    }

}