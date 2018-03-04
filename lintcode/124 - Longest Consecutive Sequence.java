public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    //based on sorting (O(nlogn))
    public int longestConsecutive(int[] num) {
        //O(nlogn) Solution
        // if (num == null || num.length == 0) return 0;
        // Arrays.sort(num);
        // int max = 1;
        // int curt = 1;
        // for (int i = 1; i < num.length; i++) {
        //     if (num[i] - num[i-1] == 1){
        //         curt++;
        //         max = Math.max(max, curt);
        //     } else if (num[i] - num[i-1] > 1) {
        //         curt = 1;
        //     }
        // }
        // return max;

        //O(n) Solution
        Set<Integer> hashset = new HashSet<>();
        int result = Integer.MIN_VALUE;

        for (int n : num) {
            hashset.add(n);
        }

        for (int n : num) {
            if (hashset.contains(n)){
                hashset.remove(n);
                int prev = n - 1;
                int next = n + 1;
                while (hashset.contains(prev)) {
                    hashset.remove(prev);
                    prev--;
                }

                while (hashset.contains(next)) {
                    hashset.remove(next);
                    next++;
                }

                int length = next - prev - 1;
                result = Math.max(result, length);

            }
        }

        return result;
    }
}