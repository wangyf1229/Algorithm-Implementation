class Solution {
    public String minWindow(String s, String t) {
        if (t == null || s == null) return null;
        if (t.length() == 0) return "";
        int[] hashtable = new int[256];
        for (int i = 0; i < t.length(); i++) {
            hashtable[t.charAt(i)]++;
        }
        
        int minLength = Integer.MAX_VALUE;
        String res = "";
        
        int start = 0;
        int end = 0;
        int count = t.length(); //# of characters waiting to be matched
        while(end < s.length()) {
            if (hashtable[s.charAt(end)] > 0) count--;
            hashtable[s.charAt(end)]--;
            end++;
            if (count == 0) {
                while(hashtable[s.charAt(start)] != 0) {
                    hashtable[s.charAt(start)]++;
                    start++;
                }
                if ((end - start) < minLength) {
                    res = s.substring(start, end);
                    minLength = end -start;
                }
                count++;
                hashtable[s.charAt(start)]++;
                start++;
            }
        }
        return res;
    }
}