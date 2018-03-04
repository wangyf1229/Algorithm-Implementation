public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public int maxLength(Set<String> dict) {
        int maxL = Integer.MIN_VALUE;
        for (String word : dict) {
            maxL  = Math.max(word.length(),maxL);
        }
        return maxL;
    }
    public boolean wordBreak(String s, Set<String> dict) {
        // int n = s.length();
        // if (n == 0) return true;
        // boolean[] f = new boolean[n];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < i + 1; j++) {
        //         if (j == 0) {
        //             f[i] = f[i] || dict.contains(s.substring(j,i+1));
        //         } else {
        //             f[i] = f[i] || f[j-1] && dict.contains(s.substring(j,i+1));
        //         }
        //     }
        // }
        // return f[n-1];

        // int n = s.length();
        // if (n == 0) return true;
        // boolean[] f = new boolean[n+1];
        // f[0] = true;
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 0; j < i; j++) {

        //         f[i] = f[i] || f[j] && dict.contains(s.substring(j,i));
        //     }
        // }
        // return f[n];

        // int n = s.length();
        // int maxL = maxLength(dict);
        // if (n == 0) return true;
        // boolean[] f = new boolean[n+1];
        // f[0] = true;
        // for (int i = 1; i < n + 1; i++) {
        //     for (int j = 0; j < i; j++) {
        //         if (i-j <= maxL){
        //             if (!f[j]) continue;
        //             if (f[i]) break;
        //             String word = s.substring(j,i);
        //             f[i] = f[i] || f[j] && dict.contains(word);
        //         }
        //     }
        // }
        // return f[n];

        int n = s.length();
        int maxL = maxLength(dict);
        if (n == 0) return true;
        boolean[] f = new boolean[n+1];
        f[0] = true;
        for (int i = 1; i < n + 1; i++) {
            for (int lastWordLength = 1; lastWordLength <= maxL && lastWordLength<= i; lastWordLength++) {
                if (!f[i-lastWordLength]) continue;
                String word = s.substring(i-lastWordLength, i);
                f[i] = f[i] || f[i-lastWordLength] && dict.contains(word);
                if (f[i]) break;
            }
        }
        return f[n];
    }
}