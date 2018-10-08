//DFS
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> nodeMap = new HashMap<>();
        
        //Build the graph
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!nodeMap.containsKey(account.get(i))) {
                    nodeMap.put(account.get(i), new HashSet<>());
                }
                if (i > 1) {
                    nodeMap.get(account.get(i)).add(account.get(i-1));
                    nodeMap.get(account.get(i-1)).add(account.get(i));
                }
            }
        }
        
        Set<String> visited = new HashSet<String>();
        List<List<String>> res = new ArrayList<>();
        for (List<String> account : accounts) {
            if (!visited.contains(account.get(1))) {
                List<String> emails = new ArrayList<>();
                dfs(emails, nodeMap, visited, account.get(1));
                Collections.sort(emails);
                emails.add(0, account.get(0));
                res.add(emails);
            }
        }
        return res;
    }
    
    public void dfs(List<String> emails, Map<String, Set<String>> nodeMap, Set<String> visited, String root) {
        if (visited.contains(root)) return;
        visited.add(root);
        emails.add(root);
        Set<String> neighbours = nodeMap.get(root);
        for (String next : neighbours) {
            dfs(emails, nodeMap, visited, next);
        }
    }
}



//Union Find
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        
        Map<String, String> owner = new HashMap<>();
        Map<String, Set<String>> unions = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        
        //Initialize the union find, make the root of each email itself
        for (List<String> account: accounts) {
            for(int i = 1; i < account.size(); i++) {
                owner.put(account.get(i), account.get(0));
                parents.put(account.get(i), account.get(i));
            }
        }
        
        //Make the first email of the account be the root. If there is overlap, union these two accounts
        for (List<String> account: accounts) {
            for (int i = 2; i < account.size(); i++) {
                union(account.get(1), account.get(i), parents);
            }
        }
        
        //Add the same union to one set
        for (List<String> account: accounts) {
            String rootOfAccount = find(account.get(1), parents);
            if (!unions.containsKey(rootOfAccount)) {
                unions.put(rootOfAccount, new HashSet<>());
            }
            for (int i = 1; i < account.size(); i++) {
                unions.get(rootOfAccount).add(account.get(i));
            }
        }
        
        //Add the emails of the same union to the result
        List<List<String>> res = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> tuple = new ArrayList<>();
            tuple.addAll(unions.get(root));
            Collections.sort(tuple);
            tuple.add(0, owner.get(root));
            res.add(tuple);
        }
        return res;  
    }
    
    public String find(String x, Map<String, String> parents) {
        if (!parents.get(x).equals(x)) {
            String root = find(parents.get(x), parents);
            parents.put(x,root);
            return root;
        }
        return x;
    }
    
    public void union(String x, String y, Map<String, String> parents) {
        //the root of X becomes the root of Y
        String rootOfX = find(x, parents);
        String rootOfY = find(y, parents);
        parents.put(rootOfY, rootOfX);
    }
}