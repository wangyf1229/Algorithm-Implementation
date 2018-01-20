class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");
        for (String str: split) {
            if (str.equals("..")) {
                if (! stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }
        String res = "";
        while (! stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.equals("")) return "/";
        return res;
    }
}