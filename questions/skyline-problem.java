/**
https://discuss.leetcode.com/topic/28482/once-for-all-explanation-with-clean-java-code-o-n-2-time-o-n-space
http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/

Alternate solution:

https://github.com/mission-peace/interview/blob/master/src/com/interview/geometry/SkylineDrawing.java


Firstly, please notice what we need to achieve:

  1. visit all start points and all end points in order;
  2. when visiting a point, we need to know whether it is a start point or a
      end point, based on which we can add a height or delete a height from
      our data structure;
To achieve this, his implementation:

  1. use a int[][] to collect all [start point, - height] and [end point, height]
      for every building;
  2. sort it, firstly based on the first value, then use the second to break
      ties;
Thus,

  1. we can visit all points in order;
  2. when points have the same value, higher height will shadow the lower one;
  3. we know whether current point is a start point or a end point based on the
      sign of its height;

Time - O(n^2)
Space - O(n)

*/

public class Solution {
    class Edge {
	int x;
	int height;
 
	public Edge(int x, int height) {
		this.x = x;
		this.height = height;
	}
}

    public List<int[]> getSkyline(int[][] buildings) {
       List<int[]> result = new ArrayList<int[]>();
 
	    if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
		    return result;
	    }
 
	    List<Edge> edges = new ArrayList<Edge>();
 
	    // add all left/right edges
	    for (int[] building : buildings) {
	        // start point has negative height value
		    Edge startEdge = new Edge(building[0], -building[2]);
		    edges.add(startEdge);
		 // end point has normal height value
		    Edge endEdge = new Edge(building[1], building[2]);
		    edges.add(endEdge);
	    }
 
	    // sort height, based on the first value, if necessary, use the second to break ties 
	    Collections.sort(edges, new Comparator<Edge>() {
		    public int compare(Edge a, Edge b) {
			    if (a.x != b.x)
				    return Integer.compare(a.x, b.x);
			    
 			    // compare the heights if they are both start or end edges , 
			    return Integer.compare(a.height, b.height);
		    }
	    });
	
    // Use a maxHeap to store possible heights
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder()); // The Collections.reverseOrder() provides a Comparator that would sort the elements in the PriorityQueue in a the oposite order to their natural order in this case.    

    // Provide a initial value to make it more consistent
    pq.offer(0); // initial max height is 0 

    // Before starting, the previous max height is 0;
    int prev = 0;

    // visit all points in order
    for(Edge edge : edges) {
        if(edge.height < 0) { // if its a start point, add height
            pq.offer(-edge.height);
        } else {  // a end point, remove height
            pq.remove(edge.height);
        }
        int cur = pq.peek(); // current max height;
  
        // compare current max height with previous max height, update result and 
        // previous max height if necessary
        if(prev != cur) {
            result.add(new int[]{edge.x,cur});
            prev = cur;
        }
    }
    return result;
}
