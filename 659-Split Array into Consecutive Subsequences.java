class Solution {
    public boolean isPossible(int[] nums) {
        //int[] a a[0] -> size a[1] -> end number
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]> (){
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) return a[0] - b[0];
                return a[1] - b[1];
            }
        });
        for (int i : nums) {
            int[] seq = pq.peek();
            while (seq != null && seq[1] < (i - 1)) {
                if (seq[0] >= 3) {
                    pq.poll();
                    seq = pq.peek();
                } else {
                    return false;
                }
            }
            //seq == null || seq[1] >= (i - 1);
            if (seq == null || seq[1] > (i - 1)) {
                seq = new int[]{1, i};
                pq.offer(seq);
            } else {
                pq.poll();
                seq[1]++;
                seq[0]++;
                pq.offer(seq);
            }  
        }
        Iterator<int[]> iter = pq.iterator();
        while (iter.hasNext()) {
            int[] temp = iter.next();
            if (temp[0] < 3) return false;
        }
        return true;
    }
}