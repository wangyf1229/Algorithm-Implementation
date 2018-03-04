public class Solution {
    /*
     * @param n: An integer
     * @return: the nth prime number as description.
     */
    public int nthUglyNumber(int n) {
        //HashSet + PriorityQueue => O(nlogn)
        //Be careful of int overflow
        // Set<Long> allNum = new HashSet<>();
        // PriorityQueue<Long> minHeap = new PriorityQueue<>();
        // int[] primes = new int[3];
        // primes[0] = 2;
        // primes[1] = 3;
        // primes[2] = 5;
        // minHeap.add(Long.valueOf(1));
        // int index = 1;
        // long a = 1;
        // while (index <= n) {
        //     a = minHeap.poll();
        //     for (int i = 0; i < 3; i++) {
        //         if (! allNum.contains(Long.valueOf(primes[i] * a))) {
        //             allNum.add(Long.valueOf(primes[i] * a));
        //             minHeap.add(Long.valueOf(primes[i] * a));
        //         }
        //     }
        //     index++;
        // }
        // return (int) a;

        //O(n) Solution
        int min = 1;
        int[] uglyNum = new int[n];
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int prime2 = 2;
        int prime3 = 3;
        int prime5 = 5;
        uglyNum[0] = 1;
        for (int i = 1; i < n; i++) {
            min = Math.min(uglyNum[index2]*prime2, Math.min(uglyNum[index3]*prime3, uglyNum[index5]*prime5));
            uglyNum[i] = min;
            if (min == uglyNum[index2] * prime2) index2++;
            if (min == uglyNum[index3] * prime3) index3++;
            if (min == uglyNum[index5] * prime5) index5++;
        }
        return min;


    }
}