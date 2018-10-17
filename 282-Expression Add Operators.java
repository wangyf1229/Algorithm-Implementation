class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(0) == '0' && i != 0) continue;
            String numStr = num.substring(0, i+1);
            long cur = Long.parseLong(numStr);
            helper(num, target, i + 1, numStr, cur, cur, res);
        }
        return res;
    }
    
    public void helper(String num, int target, int idx, String equa, long prev, long mult, List<String> res) {
        if (idx == num.length() && prev == target) {
            res.add(new String(equa));
        }
        if (idx >= num.length()) return;
        for (int i = idx; i < num.length(); i++) {
            if (num.charAt(idx) == '0' && i != idx) continue;
            String number = num.substring(idx, i+1);
            long cur = Long.parseLong(number);
            helper(num, target, i + 1, equa + "+" + number, prev + cur, cur, res);
            helper(num, target, i + 1, equa + "-" + number, prev - cur, -cur, res);
            helper(num, target, i + 1, equa + "*" + number, prev - mult + mult*cur, mult*cur, res);
        } 
    }
}