class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] dic = new int[26];
        for (int i = 0; i < s.length(); i++) {
            dic[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            dic[t.charAt(i) - 'a'] -= 1;
            if (dic[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}