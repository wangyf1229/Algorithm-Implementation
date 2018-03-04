class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        helper(s, "", 0, 0, res);
        return res;
    }

    public void helper(String s, String cur, int seg, int start, List<String> res) {
        if (start > s.length()) return;
        int remaining = s.length() - start;
        if (remaining > 3 * (4 - seg)) return;
        if (start == s.length() && seg == 4) {
            res.add(cur);
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) continue;
            String part = s.substring(start, start + i);
            if (s.charAt(start) == '0' && (i == 2 || i == 3)) continue;
            if (i == 3) {
                int aft = Integer.parseInt(part);
                if (aft > 255) continue;
            }
            String cand = cur.equals("")? part : cur + "." + part;
            helper(s, cand, seg + 1, start + i, res);
        }
    }
}