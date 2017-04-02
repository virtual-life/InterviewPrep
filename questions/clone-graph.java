/**

Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2  #  1,2   #2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/

Time - O(E*V )

*/


/**
 * Definition for undirected graph.
 * class GraphNode {
 *     int label;
 *     List<GraphNode> neighbors;
 *     GraphNode(int x) { label = x; neighbors = new ArrayList<GraphNode>(); }
 * };
 */

/**

a queue is used to do breath first traversal,
and a map is used to store the visited nodes. It is the map between original node and copied node.

*/


public GraphNode cloneGraph(GraphNode node) {
    if(node == null)
        return null;
 
    Queue<GraphNode> queue = new LinkedList<GraphNode>();
 
    HashMap<GraphNode,GraphNode> map = new HashMap<GraphNode,GraphNode>();
 
    queue.add(node);
    GraphNode newNodeCopy = new GraphNode(node.label);
    map.put(node, newNodeCopy);
 
    while(!queue.isEmpty()){
        GraphNode curr = queue.remove();
        List<GraphNode> currNeighbors = curr.neighbors; 
 
        for(GraphNode aNeighbor: currNeighbors){
            if(!map.containsKey(aNeighbor)){
                GraphNode copy = new GraphNode(aNeighbor.label);
                map.put(aNeighbor,copy);
                map.get(curr).neighbors.add(copy);
                queue.add(aNeighbor);
            }else{
                // add neighbor's value to curr's neighbor's
                   //OR
                // get current's copy
                //now get its nrighbos and add
                // neighbor's copy to it 
                  
                map.get(curr).neighbors.add(map.get(aNeighbor));
            }
        }
     }
     return newNodeCopy;
}
