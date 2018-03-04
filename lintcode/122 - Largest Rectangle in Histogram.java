public class Solution {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = i == height.length ? -1 : height[i];
            while (!stack.empty() && height[stack.peek()] > curt) {
                int top = stack.pop();
                int firstIndex = stack.empty()? -1 : stack.peek();
                int area = (i - firstIndex - 1) * height[top];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
