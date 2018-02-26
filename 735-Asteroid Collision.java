class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) return asteroids;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0 || (stack.peek() < 0 && asteroids[i] < 0)) {
                stack.push(asteroids[i]);
                continue;
            }
            boolean exploded = false;
            while (! stack.isEmpty() && stack.peek() > 0) {
                int before = stack.pop();
                int size = Math.abs(asteroids[i]);
                if (size == before) {
                    exploded = true;
                    break;
                } else if (size < before) {
                    stack.push(before);
                    exploded = true;
                    break;
                }
            }
            if (! exploded) stack.push(asteroids[i]);
        }
        int[] res = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}