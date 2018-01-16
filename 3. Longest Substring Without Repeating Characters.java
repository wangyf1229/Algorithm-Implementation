class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] charArray = s.toCharArray();
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        int left, right;

        //left => the first character of the substring considering right now
        //right => the current character of the substring considering right now
        for (left = 0, right = 0; right < charArray.length; right++) {
            if (! map.containsKey(charArray[right])) {
                map.put(charArray[right],right);
            } else {
                //To avoid the rollback of the left, e.g. "abba"
                left = Math.max(map.get(charArray[right]) + 1, left);
                map.put(charArray[right], right);
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0;
        int max = 0;
        int end = 0;
        while (start < s.length() && end < s.length()) {
            if (! set.contains(s.charAt(end))) {
                set.add(s.charAt(end));
                max = Math.max(max, (end - start + 1));
                end ++;
            } else {
                set.remove(s.charAt(start));
                start ++;
            }
        }
        return max;
    }
}