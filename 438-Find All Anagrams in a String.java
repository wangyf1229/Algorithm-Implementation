class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList<>();
        if(s == null) return res;
        int[] hashtable = new int[26];
        char[] pArray = p.toCharArray();
        for (char c: pArray) {
            hashtable[c-'a']++;
        }
        
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            int[] dict = Arrays.copyOf(hashtable, 26);
            boolean isAnagram = true;
            for (int j = i; j < i + p.length(); j++) {
                dict[sArray[j] - 'a']--;
                if (dict[sArray[j] - 'a'] < 0) {
                    isAnagram = false;
                    break;
                }
            }
            if (isAnagram) res.add(i);
        }
        return res;
    }

    //better solution
    public List<Integer> findAnagrams(String s, String p) {    
        List<Integer> res = new ArrayList<>();
        if(s == null) return res;
        int[] hashtable = new int[26];
        char[] array = p.toCharArray();
        for (char c: array) {
            hashtable[c-'a']++;
        }
        int count = p.length();
        int start = 0;
        int end = 0;
        while(end < s.length()) {
            if (hashtable[s.charAt(end) - 'a'] > 0) count--;
            hashtable[s.charAt(end) - 'a']--;
            end++;
            if ((end - start) == p.length()) {
                if (count == 0) res.add(start);
                hashtable[s.charAt(start) - 'a']++;
                if (hashtable[s.charAt(start) - 'a'] > 0) count++;
                start++;
            }
        }
        return res;
    }
}