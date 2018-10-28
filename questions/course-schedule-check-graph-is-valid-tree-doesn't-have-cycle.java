import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**

 There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.

 Hints:
 This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 Topological sort could also be done via BFS.


 */

/*
http://buttercola.blogspot.com/2015/08/leetcode-course-schedule.html
DFS Solution:
Use an array to mark if the node has been visited before. Here is a small trick to save some time. Instead of using a boolean array, we use an integer array int[] visited.
visited = -1, means this node has been visited.
visited = 1, means this node has been validated which does not include a circle.
Thus if we saw that a node has been validated, we don't need to calculate again to find out the circle starting from this node. e.g. [0, 1] [1, 2] [2, 3] [3, 4].
For the node 0, we have already validated 2 3 and 4 do not have a circle. Thus we don't need to calculate for the node 2 3 4 again.
 */

/**
Check is graph is valid tree 
    public boolean validTree(int n, int[][] edges) {
        
    }
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return true;
        }

        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        // First transform the edge list to adj. list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : prerequisites) {
            if (adjList.containsKey(edge[0])) {
                List<Integer> neighbors = adjList.get(edge[0]);
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            } else {
                List<Integer> neighbors = new ArrayList<Integer>();
                neighbors.add(edge[1]);
                adjList.put(edge[0], neighbors);
            }
        }

        boolean[] visited = new boolean[numCourses];
        // Check if the graph contains a circle, if yes, return false.
        for (int i = 0; i < numCourses; i++) {
            if (hasCircles(i, visited, adjList)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCircles(int vertexId, int[] visited, Map<Integer, List<Integer>> adjList) {
        if (visited[vertexId]) {
            return true;
        }

        // mark node as visited 
        visited[vertexId] = true;

        List<Integer> neighbors = adjList.get(vertexId);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (hasCircles(neighbor, visited, adjList)) {
                    return true;
                }
            }
        }
        // reset node 
        visited[vertexId] = false;

        return false;
    }
}
