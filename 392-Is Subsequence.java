class Solution {
    public boolean isSubsequence(String s, String t) {
        int ptrS = 0;
        int ptrT = 0;
        while (ptrT < t.length()) {
            if (ptrS >= s.length()) return true;
            if (s.charAt(ptrS) == t.charAt(ptrT)) {
                ptrS++;
                ptrT++;
            } else {
                ptrT++;
            }
        }
        if (ptrS >= s.length()) return true;
        return false;
    }
}

class Solution {
    public boolean isSubsequence(String s, String t) {
        //Follow up
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), new ArrayList<Integer>());
            }
            map.get(t.charAt(i)).add(i);
        }

        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) return false;
            List<Integer> list = map.get(s.charAt(i));
            //binary search
            //find the first index which is larger than index
            int start = 0;
            int end = list.size() - 1;
            while (start + 1 < end) {
                int mid = (start + end)/2;
                int midIdx = list.get((start + end)/2);
                if (midIdx > index) end = mid;
                if (midIdx <= index) start = mid;
            }
            if (list.get(start) > index) {
                index = list.get(start);
            } else if (list.get(end) > index) {
                index = list.get(end);
            } else {
                return false;
            }
        }
        return true;
    }
}