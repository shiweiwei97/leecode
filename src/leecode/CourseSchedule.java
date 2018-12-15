package leecode;

import java.util.ArrayList;
import java.util.List;

/***
 * https://leetcode.com/problems/course-schedule/
 * 
 * @author weiweish
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<List<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<Integer>());
        }

        for (int[] pair : prerequisites) {
            edges.get(pair[0]).add(pair[1]);
        }

        return !hasCircle(edges);
    }

    private boolean hasCircle(List<List<Integer>> edges) {
        boolean[] visited = new boolean[edges.size()];
        boolean[] path = new boolean[edges.size()];

        for (int i = 0; i < edges.size(); i++) {
            if (!visited[i] && dfs(i, edges, visited, path)) return true;
        }

        return false;
    }

    private boolean dfs(int i, List<List<Integer>> edges, boolean[] visited, boolean[] path) {
        // has circle
        if (path[i]) return true;

        // visited
        if (visited[i]) return false;

        visited[i] = true;
        path[i] = true;

        for (int edge : edges.get(i)) {
            if (dfs(edge, edges, visited, path)) return true;
        }

        path[i] = false;
        return false;
    }

    public static void main(String[] args) {

        CourseSchedule c = new CourseSchedule();
        int[][] prerequisites = { { 0, 1 }, { 1, 0 } };

        System.out.println(c.canFinish(2, prerequisites));
    }

}
