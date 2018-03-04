public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    //Based on hashing
    // public List<String> anagrams(String[] strs) {
    //     ArrayList<String> result = new ArrayList<String>();
    //     Map<Integer, ArrayList<String>> hashmap = new HashMap<Integer, ArrayList<String>>();
    //     for (int i = 0; i < strs.length; i++) {
    //         int hashcode = hashFunc(strs[i]);
    //         if (!hashmap.containsKey(hashcode)) {
    //             ArrayList<String> empty = new ArrayList<String>();
    //             hashmap.put(hashcode, empty);
    //         }
    //         hashmap.get(hashcode).add(strs[i]);
    //     }

    //     for (ArrayList<String> tmp : hashmap.values()) {
    //         if (tmp.size() > 1) {
    //             result.addAll(tmp);
    //         }
    //     }
    //     return result;
    // }

    //Based on sorting
    public List<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        Map<String, ArrayList<String>> hashmap = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] newChar = strs[i].toCharArray();
            Arrays.sort(newChar);
            String newString = String.valueOf(newChar);
            if (!hashmap.containsKey(newString)) {
                ArrayList<String> empty = new ArrayList<String>();
                hashmap.put(newString, empty);
            }
            hashmap.get(newString).add(strs[i]);
        }

        for (ArrayList<String> tmp : hashmap.values()) {
            if (tmp.size() > 1) {
                result.addAll(tmp);
            }
        }
        return result;
    }

    public int hashFunc(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)-'a']++;
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum*31 + count[i];
        }
        return sum;
    }

}