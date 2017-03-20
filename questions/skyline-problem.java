/**
https://discuss.leetcode.com/topic/28482/once-for-all-explanation-with-clean-java-code-o-n-2-time-o-n-space
http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/

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
 
	    // sort height, based on the first value, if necessary, use the second to
        // break ties 
	    Collections.sort(edges, new Comparator<Edge>() {
		    public int compare(Edge a, Edge b) {
			    if (a.x != b.x)
				    return Integer.compare(a.x, b.x);
 
			    return Integer.compare(a.height, b.height);
		    }
	    });
 
 
        TreeMap<Integer, Integer> heightMap = new TreeMap<Integer, Integer>(Collections.reverseOrder());
        // Before starting, the previous max height is 0;
        heightMap.put(0,1);
        int prev = 0;
        for (Edge edge : edges) {
            if (edge.height < 0) { 
                Integer cnt = heightMap.get(-edge.height);
                if(cnt == null){
                    cnt = 1;
                }else{
                    cnt = cnt + 1;
                }
			    heightMap.put(-edge.height,cnt);
			    
            } else {  
                Integer cnt = heightMap.get(edge.height);
                if(cnt == 1){
                    heightMap.remove(edge.height);
                }else{
                    heightMap.put(edge.height, cnt - 1);
                }
            }
            int cur =  heightMap.firstKey();
            if(prev != cur){
                result.add(new int[]{edge.x,cur});
                prev = cur;
            }
        }
	return result; 
    }
}
