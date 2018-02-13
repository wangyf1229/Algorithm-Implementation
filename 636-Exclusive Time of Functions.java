class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> func = new Stack<>();
        Stack<Integer> time = new Stack<>();
        for(String oneLog: logs) {
            String[] logArray = oneLog.split(":");
            int func_id = Integer.parseInt(logArray[0]);
            String start_or_end = logArray[1];
            int timestamp = Integer.parseInt(logArray[2]);
            if (start_or_end.equals("start")) {
                time.push(timestamp);
                func.push(func_id);
            } else {
                int start = time.pop();
                func.pop();
                res[func_id] += (timestamp - start + 1);
                if (! func.isEmpty()) {
                    int i = func.peek();
                    res[i] -= (timestamp - start + 1);
                }

            }
        }
        return res;
    }
}