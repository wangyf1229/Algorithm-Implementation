class Solution {
    
    public class Node {
        String cur;
        Node root;
        double val;
        public Node(String cur, double val) {
            this.cur = cur;
            this.root = this;
            this.val = val;
        }
    }
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        //Union Find
         Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equa = equations[i];
            Node fir;
            Node sec;
            if (map.containsKey(equa[0])) {
                fir = map.get(equa[0]);
            } else {
                fir = new Node(equa[0], 1);
                map.put(equa[0], fir);
            }
            if (map.containsKey(equa[1])) {
                sec = map.get(equa[1]);
            } else {
                sec = new Node(equa[1], 1);
                map.put(equa[1], sec);
            }
            union(fir, sec, values[i]);
        }
        
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            Node fir = map.get(queries[i][0]);
            Node sec = map.get(queries[i][1]);
            if (fir == null || sec == null) {
                res[i] = -1.0;
                continue;
            }
            Node firRoot = find(fir);
            Node secRoot = find(sec);
            if (firRoot != secRoot) {
                res[i] = -1.0;
                continue;
            }
            res[i] = fir.val/sec.val;
        }
        return res;
    }
    
    public Node find(Node n) {
        if (n.root != n) {
            Node rootBef = n.root;
            n.root = find(n.root);
            n.val = n.val * rootBef.val;
        }
        return n.root;
    }
    
    public void union(Node x, Node y, double v) {
        //val => x = v * y
        //the root of x becomes the root of y;
        Node yRoot = find(y);
        Node xRoot = find(x);
        yRoot.val = x.val/(y.val * v);
        yRoot.root = xRoot;
    }
}

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, List<String>> edgesMap = new HashMap<>();
        Map<String, List<Double>> valuesMap = new HashMap<>();
        
        //Adjacency List
        for (int i = 0; i < equations.length; i++) {
            String[] equa = equations[i];
            if (!edgesMap.containsKey(equa[0])) {
                edgesMap.put(equa[0], new ArrayList<String>());
                valuesMap.put(equa[0], new ArrayList<Double>());
            }
            if (!edgesMap.containsKey(equa[1])) {
                edgesMap.put(equa[1], new ArrayList<String>());
                valuesMap.put(equa[1],new ArrayList<Double>());
            }
            edgesMap.get(equa[0]).add(equa[1]);
            edgesMap.get(equa[1]).add(equa[0]);
            valuesMap.get(equa[0]).add(values[i]);
            valuesMap.get(equa[1]).add(1.0/values[i]);
        }
        
        //create the result
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!edgesMap.containsKey(queries[i][0]) || !edgesMap.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            res[i] = dfs(edgesMap, valuesMap, queries[i][0], queries[i][1], new HashSet<>());
        }
        return res;
    }
    
    public double dfs(Map<String, List<String>> edges, Map<String, List<Double>> values, String start, String end, Set<String> visited) {
        
        if (start.equals(end)) return 1.0;
        double res = -1.0;
        List<String> nodes = edges.get(start);
        for (int i = 0; i < nodes.size(); i++) {
            String cand = nodes.get(i);
            if (!visited.contains(cand)) {
                visited.add(cand);
                res = dfs(edges, values, cand, end, visited);
                if (res != -1.0) {
                    //find the path between start and end
                    res = values.get(start).get(i) * res;
                    break;
                }
            }
        }
        return res;
        
    }
}

class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> node = new HashMap<>();
        int idx = 0;
        for (String[] equa : equations) {
            if (!node.containsKey(equa[0])) node.put(equa[0], idx++);
            if (!node.containsKey(equa[1])) node.put(equa[1], idx++);
        }
        
        //create adjacency matrix
        double[][] matrix = new double[idx + 1][idx + 1]; //matrix[i][j] = i/j
        for (int i = 0; i < equations.length; i++) {
            String[] equa = equations[i];
            int idx0 = node.get(equa[0]);
            int idx1 = node.get(equa[1]);
            matrix[idx0][idx1] = values[i];
            matrix[idx1][idx0] = 1.0 / values[i];
        }
        
        //create the result
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (!node.containsKey(queries[i][0]) || !node.containsKey(queries[i][1])) {
                res[i] = -1.0;
                continue;
            }
            res[i] = dfs(matrix, node.get(queries[i][0]), node.get(queries[i][1]), new HashSet<>());
        }
        return res;
    }
    
    public double dfs(double[][] matrix, int start, int end, Set<Integer> visited) {
        if (start == end) return 1.0;
        
        double[] values = matrix[start];
        double res = -1.0;
        for (int i = 0; i < values.length; i++) {
            if (!visited.contains(i) && values[i] != 0.0) {
                visited.add(i);
                res = dfs(matrix, i, end, visited);
                if (res != -1.0) {
                    //I find the path between start and end
                    res = values[i] * res;
                    break;
                }
            }
        }
        return res;
        
    }
}