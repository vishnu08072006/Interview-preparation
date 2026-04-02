import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] top = stack.peek();

            if (intervals[i][0] <= top[1]) {
                top[1] = Math.max(top[1], intervals[i][1]);
                stack.pop();
                stack.push(top);
            } else {
                stack.push(intervals[i]);
            }
        }

        int[][] result = new int[stack.size()][2];
        int i = stack.size() - 1;

        while (!stack.isEmpty()) {
            result[i--] = stack.pop();
        }

        return result;
    }
}