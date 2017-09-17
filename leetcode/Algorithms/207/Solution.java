class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) graph[prerequisites[i][0]][prerequisites[i][1]] = true;
        int[] color = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (color[i] == 0 && !canFinish(graph, color, i)) return false;
        }
        return true;
    }

    private boolean canFinish(boolean[][] graph, int[] color, int r) {
        color[r] = -1;
        for (int i = 0; i < color.length; i++) {
            if (graph[r][i]) {
                if (color[i] == -1) return false;
                else if (color[i] == 0 && !canFinish(graph, color, i)) return false;
            }
        }
        color[r] = 1;
        return true;
    }
}
