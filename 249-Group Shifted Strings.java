class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings) {
            char[] array = str.toCharArray();
            int base = array[0] - 'a';
            for (int i = 0; i < array.length; i++) {
                int temp = array[i] - 'a' - base;
                temp = temp >= 0 ? temp : temp + 26;
                array[i] = (char) ('a' + temp);
            }
            String key = String.valueOf(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        for (List<String> list: map.values()) {
            res.add(new ArrayList<String>(list));
        }
        return res;
    }

}