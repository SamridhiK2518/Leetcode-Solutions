import java.util.*;

public class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            indegree[to]++;
        }

        // Queue for topological sort
        Queue<Integer> queue = new LinkedList<>();

        // 2D array to track max frequency of each color (26 letters)
        int[][] colorCount = new int[n][26];

        // Initialize queue with nodes of indegree 0
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        int maxColorValue = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            int colorIndex = colors.charAt(node) - 'a';
            colorCount[node][colorIndex]++;
            maxColorValue = Math.max(maxColorValue, colorCount[node][colorIndex]);

            for (int neighbor : graph.get(node)) {
                for (int c = 0; c < 26; c++) {
                    colorCount[neighbor][c] = Math.max(colorCount[neighbor][c], colorCount[node][c]);
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If not all nodes are visited, there is a cycle
        return visited == n ? maxColorValue : -1;
    }
}
