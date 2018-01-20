class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (! map.containsKey(s.charAt(i))) {
                if (set.contains(t.charAt(i))) return false;
                set.add(t.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] sChar = new int[256];
        int[] tChar = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (sChar[(int) s.charAt(i)] != tChar[(int) t.charAt(i)]) {
                return false;
            } else {
                sChar[(int) s.charAt(i)] = tChar[(int) t.charAt(i)] = (int) s.charAt(i);
            }
        }
        return true;
    }
}