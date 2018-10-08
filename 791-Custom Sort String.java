class Solution {
    public String customSortString(String S, String T) {
        int[] tArray = new int[26];
        for (int i = 0; i < T.length(); i++) {
            tArray[T.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            int cur = S.charAt(i) - 'a';
            //pay special attention here! tArray[cur] will change in the loop!
            int times = tArray[cur];
            for (int j = 0; j < times; j++) {
                sb.append(S.charAt(i));
                tArray[cur]--;
            }
        }
        
        for (int i = 0; i < tArray.length; i++) {
            for (int j = 0; j < tArray[i]; j++) {
                char curChar = (char) ((int)'a' + i);
                sb.append(curChar);
            }
        }
        return sb.toString();      
    }
}