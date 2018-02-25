class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] str_array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str_array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str_array, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        String res = "";
        int zeroNum = 0;
        for (String str: str_array) {
            if (str.equals("0")) zeroNum++;
            res += str;
        }
        if (zeroNum == str_array.length) return "0";
        return res;
    }
}