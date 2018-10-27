//两种方法 主要目的是找到在座两个学生之间相距最远的一段距离，然后把学生放在中间。
    //1. using a list to record the index of the students
    //   seat() => 扫一遍list然后看哪两个学生之间坐得最远，插入当中
    //   leave() => 扫一遍list然后看应该移除哪一个
    //2. PriorityQueue => 存int[]，然后按照distance排序，大的在前，如果distance相同，序号小的在前
    //   distance是指如果该段interval被选中，有同学坐进去以后the distance to the closest person
    //   seat() => 只需pop出最上面一个，然后得到index
    //   leave() => 扫一遍priorityqueue，记录和这个同学有关的index,然后再重新插入。

class ExamRoom {
    List<Integer> seats;
    int N;
    public ExamRoom(int N) {
        this.N = N;
        seats = new ArrayList<>();
    }
    
    public int seat() {
        //O(n)
        int maxDistance = -1;
        int res = 0;
        int index = 0;
        for (int i = 0; i <= seats.size(); i++) {
            int start = i == 0 ? -1 : seats.get(i - 1);
            int end = i == seats.size() ? N : seats.get(i);
            int mid = (start + end)/2;
            int dist = Math.min(mid - start, end - mid);
            if (start == -1 || end == N) {
                dist = end - start - 1;
                mid = start == -1? 0 : N-1;
            }
            if (maxDistance < dist) {
                maxDistance = dist;
                res = mid;
                index = i;
            }
        }
        seats.add(index, (Integer) res);
        return res;
    }
    
    public void leave(int p) {
        //O(n)
        int index = 0;
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i) == p) {
                index = i;
                break;
            }
        }
        seats.remove(index);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

class ExamRoom {
    PriorityQueue<int[]> pq;
    int N;
    public ExamRoom(int N) {
        this.pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                int mid1 = (interval1[0] + interval1[1]) / 2;
                int dist1 = Math.min((mid1 - interval1[0]), (interval1[1] - mid1));
                if (interval1[0] == -1 || interval1[1] == N) dist1 = interval1[1] - interval1[0] - 1; 
                int mid2 = (interval2[0] + interval2[1]) / 2;
                int dist2 = Math.min((mid2 - interval2[0]), (interval2[1] - mid2));
                if (interval2[0] == -1 || interval2[1] == N) dist2 = interval2[1] - interval2[0] - 1; 
                if (dist1 == dist2) {
                    return interval1[0] - interval2[0];
                }
                return dist2- dist1;
            }
        });
        this.N = N;
        //这是解决corner case的最佳方法
        pq.offer(new int[]{-1, N});
    }
    
    public int seat() {
        //O(logn)
        int[] interval = pq.poll();
        int res = 0;
        if (interval[0] == -1) {
            res = 0;
        } else if (interval[1] == N) {
            res = N - 1;
        } else {
            res = (interval[0] + interval[1])/2;
        }
        pq.offer(new int[]{interval[0], res});
        pq.offer(new int[]{res, interval[1]});
        return res;
    }
    
    public void leave(int p) {
        //O(n)
        Iterator<int[]> iter = pq.iterator();
        int[] before = new int[2];
        int[] after = new int[2];
        while(iter.hasNext()) {
            int[] interval = iter.next();
            if (interval[0] == p) {
                after = interval;
            } else if (interval[1] == p) {
                before = interval;
            }
        }
        pq.remove(before);
        pq.remove(after);
        pq.offer(new int[]{before[0], after[1]});
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */