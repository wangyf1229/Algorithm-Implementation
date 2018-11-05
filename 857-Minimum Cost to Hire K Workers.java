class Solution {
    public class Worker {
        public int wage;
        public int quality;
        public double per_qual_wage;
        
        public Worker(int wage, int quality, double per_qual_wage) {
            this.wage = wage;
            this.quality = quality;
            this.per_qual_wage = per_qual_wage;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(wage[i], quality[i], wage[i] * 1.0 / quality[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.per_qual_wage, b.per_qual_wage));
        PriorityQueue<Worker> pq = new PriorityQueue<>((a, b) -> (b.quality - a.quality));
        double total = Integer.MAX_VALUE;
        int qualitySum = 0;
        for (int i = 0; i < quality.length; i++) {
            if (i < K) {
                pq.offer(workers[i]);
                qualitySum += workers[i].quality;
                if (i == (K - 1)) {
                    total = qualitySum * workers[i].per_qual_wage;
                }
            } else {
                Worker workerIn = pq.peek();
                Worker workerOut = workers[i];
                int qualNew = qualitySum - workerIn.quality + workerOut.quality;
                //If adding workers[i] can make the sum of quality small, I will add workers[i] to priorityqueue
                if (qualitySum > qualNew) {
                    total = Math.min(total, qualNew * workerOut.per_qual_wage);
                    qualitySum = qualNew;
                    pq.poll();
                    pq.offer(workerOut);
                }
                
            }
        }
        return total;
    }
}