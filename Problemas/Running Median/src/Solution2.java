import java.io.IOException;
import java.util.*;

public class Solution2 {

    private int dist[];
    private Set<java.lang.Integer> settled;
    private PriorityQueue<Integer> pq;
    private int V; // Number of vertices
    List<List<Integer> > adj;



    // Function for Dijkstra's Algorithm
    public void dijkstra(List<List<Integer> > adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = java.lang.Integer.MAX_VALUE;

        // Add source node to the priority queue
        pq.add(0);

        // Distance to the source is 0
        dist[src] = 0;
        while (settled.size() != V) {

            // remove the minimum distance node
            // from the priority queue
            int u = pq.remove();

            // adding the node whose distance is
            // finalized
            settled.add(u);

            e_Neighbours(u);
        }
    }

    // Function to process all the neighbours
    // of the passed node
    private void e_Neighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        // All the neighbors of v
        for (int i = 0; i < adj.get(u).size(); i++) {
            Integer v = adj.get(u).get(i);

            // If current node hasn't already been processed
            if (!settled.contains(v)) {
                edgeDistance = v;
                newDistance = dist[u] + edgeDistance;

                // If new distance is cheaper in cost
                if (newDistance < dist[v])
                    dist[v] = newDistance;

                // Add the current node to the queue
                pq.add(dist[v]);
            }
        }
    }



    int minimumDistance(int numRows, int numColumns, List<List<java.lang.Integer>> area)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<java.lang.Integer>();
        pq = new PriorityQueue<Integer>(V, new Integer());

        dijkstra(area, 0);


    }

    public static void main(String[] args) throws IOException {

        List<java.lang.Integer> entrada = new ArrayList<>();
        entrada.add(1);
        entrada.add(4);
        entrada.add(2);

       // System.out.println("Entrada: " + entrada);
       // System.out.println("Resultado: " + runningMedian(3, entrada));


    }
}
