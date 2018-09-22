class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null) return false;
        char[] array = num.toCharArray();
        Map<Character, Character> map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('8', '8');
        map.put('6', '9');
        map.put('9', '6');
        int i = 0;
        int j = array.length - 1;
        while (i <= j) {
            if (!map.containsKey(array[i])) return false;
            if (map.get(array[i]) != array[j]) return false;
            i++;
            j--;
        }
        return true;
    }
}