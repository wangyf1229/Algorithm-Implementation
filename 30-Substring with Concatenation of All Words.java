class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        int wordLen = words[0].length();
        if (wordLen == 0) {
            for (int i = 0; i < s.length() + 1; i++) {
                res.add(i);
            }
            return res;
        }
        
        Map<String, Integer> template = new HashMap<>();
        for (String word : words) {
            int time = template.getOrDefault(word, 0);
            template.put(word, time + 1);
        }
        
        int size = words.length; //words waiting to be mateched;
        int start = 0;
        int window = size*wordLen;
        for (int i = 0; i < wordLen; i++) {
            for (int j = i; j <= s.length() - window; j += wordLen) {
                Map<String, Integer> map = new HashMap<>(template);
                for (int k = size - 1; k >= 0; k--) {
                    String sub = s.substring(j + k*wordLen, j + (k+1)*wordLen);
                    if (map.containsKey(sub) && map.get(sub) > 0) {
                        map.put(sub, map.get(sub) - 1);
                        if (k == 0) {
                            res.add(j);
                        }
                    } else {
                        //As j will add another wordLen in the outer loop, the assignment is equal to move j to j+(k + 1)*wordLen
                        //It is equal to move j to the end of current word.
                        j += k*wordLen; 
                        break;
                    }
                }
            }
        }
        return res;
    }
}