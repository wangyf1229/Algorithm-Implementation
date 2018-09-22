//BFS
class Solution {
    
    public List<String> removeInvalidParentheses(String s) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        List<String> res = new ArrayList<>();
        if (s == null) return res;
        boolean isFound = false;
        queue.offer(s);
        while (!queue.isEmpty()) {
            String str = queue.poll();
            if (isValid(str)) {
                isFound = true;
                res.add(str);
            }
            if (isFound) continue;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == ')') {
                    String candidate = str.substring(0, i) + str.substring(i + 1);
                    if (!visited.contains(candidate)) {
                        queue.offer(candidate);
                        visited.add(candidate);
                    }
                }
            }   
        }
        return res;
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')'){
                count--;
            }
            if (count < 0) return false;
        }
        return count == 0;
    }
    
}

//DFS
class Solution {
    
    public int maxLength;
    public Set<String> res;
    
    public List<String> removeInvalidParentheses(String s) {
        if (s == null) return new ArrayList<>();
        maxLength = 0;
        res = new HashSet<>();
        dfsHelper(s, 0);
        return new ArrayList<String>(res);
    }
    
    public void dfsHelper(String s, int lastRemoval) {
        if (s.length() < maxLength) return;
        if (!isValid(s)) {
            for (int i = lastRemoval; i < s.length(); i++) {
                dfsHelper(s.substring(0, i) + s.substring(i + 1), i);
            }
        } else {
            if (maxLength < s.length()) {
                maxLength = s.length();
                res = new HashSet<>();
            }
            res.add(s);
        }  
    }
    
    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}