class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int start = 0;
        while (start < prev.length() - 1) {
            int count = 1;
            while (start < prev.length() - 1 && prev.charAt(start) == prev.charAt(start + 1)) {
                start++;
                count++;
            }
            //start == prev.length() - 1 (the last char is the same as before)
            sb.append(count);
            sb.append(prev.charAt(start));
            start++;
        }
        //if start == prev.length - 1, the last char is different from the last but 1 char
        //if start == prev.length, the last char is the same as before
        if (start == prev.length() - 1) {
            sb.append(1);
            sb.append(prev.charAt(start));
        }
        return sb.toString();
    }
}