class Solution {
    //based on hashing
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<Integer, List<String>> hashmap = new HashMap<>();
        for (String str: strs) {
            int hashcode = hashCode(str);
            if (hashmap.containsKey(hashcode)) {
                List<String> temp = hashmap.get(hashcode);
                temp.add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                hashmap.put(hashcode, temp);
            }
        }

        for (List<String> oneres: hashmap.values()) {
            res.add(oneres);
        }
        return res;
    }

    //based on sorting
     public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        Map<String, List<String>> hashmap = new HashMap<>();
        for (String str: strs) {
            char[] charArray = str.toCharArray();
            //len => O(len*log(len))
            Arrays.sort(charArray);
            String newStr = String.valueOf(charArray);
            if (hashmap.containsKey(newStr)) {
                List<String> temp = hashmap.get(newStr);
                temp.add(str);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                hashmap.put(newStr, temp);
            }
        }

        for (List<String> oneres: hashmap.values()) {
            res.add(oneres);
        }
        return res;
     }

    public int hashCode(String str) {
        int[] charArray = new int[26];
        for (int i = 0; i < str.length(); i++) {
            charArray[str.charAt(i) - 'a']++;
        }
        int sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            sum = sum * 31 + charArray[i];
        }
        return sum;
    }
}