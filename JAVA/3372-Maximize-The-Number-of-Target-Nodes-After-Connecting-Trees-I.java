import java.util.*;

public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;

        List<List<Integer>> tree1 = buildTree(n, edges1);
        List<List<Integer>> tree2 = buildTree(m, edges2);

        int[] count1 = new int[n];
        int[] count2 = new int[m];

        for (int i = 0; i < n; i++) {
            count1[i] = bfsCount(tree1, i, k);
        }

        for (int j = 0; j < m; j++) {
            count2[j] = bfsCount(tree2, j, k - 1); // one step for the bridge
        }

        // Get max reachable count from any node in tree2
        int maxCount2 = 0;
        for (int c : count2) {
            maxCount2 = Math.max(maxCount2, c);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count1[i] + maxCount2;
        }

        return res;
    }

    private List<List<Integer>> buildTree(int size, int[][] edges) {
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        return tree;
    }

    private int bfsCount(List<List<Integer>> tree, int start, int maxDist) {
        boolean[] visited = new boolean[tree.size()];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0], dist = curr[1];
            if (dist > maxDist) continue;

            count++;

            for (int neighbor : tree.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return count;
    }
}
