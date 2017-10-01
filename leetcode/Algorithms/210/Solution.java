class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][1]][prerequisites[i][0]] = true;
        int[] color = new int[numCourses];
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0) if (!visit(graph, color, i, res)) return new int[]{};
        }
        int[] nums = new int[numCourses];
        for (int i = 0; i < numCourses; i++) nums[i] = res.get(i);
        return nums;
    }

    private boolean visit(boolean[][] graph, int[] color, int index, List<Integer> res) {
        color[index] = -1;
        for (int i = 0; i < color.length; i++) {
            if (graph[index][i]) {
                if (color[i] == 0 && !visit(graph, color, i, res) || color[i] == -1) return false;
            }
        }
        color[index] = 1;
        res.add(0, index);
        return true;
    }

}
