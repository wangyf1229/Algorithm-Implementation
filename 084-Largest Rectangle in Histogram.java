class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area = 0;
        int ptr = 0;
        while (ptr <= heights.length) {
            int curH = ptr == heights.length ? 0: heights[ptr];
            if (stack.isEmpty() || curH >= heights[stack.peek()]) {
                stack.push(ptr);
                ptr++;
            } else {
                int cur = stack.pop();
                int idxL = stack.isEmpty() ? -1 : stack.peek();
                int areaCur = (ptr - idxL - 1) * heights[cur];
                area = Math.max(area, areaCur);
            }
        }
        return area;
    }
}