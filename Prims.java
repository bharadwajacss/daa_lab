// A Java program for Prim's Minimum Spanning Tree (MST)
// algorithm. The program is for adjacency matrix
// representation of the graph

import java.io.*;
import java.lang.*;
import java.util.*;

class Prims {

    // A utility function to find the vertex with minimum
    // key value, from the set of vertices not yet included
    // in MST
    int minKey(int key[], Boolean mstSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < mstSet.length; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST
    // stored in parent[]
    void printMST(int parent[], int[] key)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < key.length; i++)
            System.out.println(parent[i] + " - " + i + "\t"
                               + key[i]);
    }

    // Function to construct and print MST for a graph
    // represented using adjacency matrix representation
    void primMST(int graph[][])
    {
        int V = graph.length;
        
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in
        // cut
        int key[] = new int[V];

        // To represent set of vertices included in MST
        Boolean mstSet[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // Always include first 1st vertex in MST.
        // Make key 0 so that this vertex is
        // picked as first vertex
        key[0] = 0;
      
        // First node is always root of MST
        parent[0] = -1;

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            
            // Pick the minimum key vertex from the set of
            // vertices not yet included in MST
            int u = minKey(key, mstSet);
            
            // Add the picked vertex to the MST Set
            mstSet[u] = true;

            // Update key value and parent index of the
            // adjacent vertices of the picked vertex.
            // Consider only those vertices which are not
            // yet included in MST
            for (int v = 0; v < V; v++){

                // this if block is to check if the edge is not 0 and 
                // the vertex is not in the mstSet and 
                // the weight of the edge is less than the key of the vertex
               
                if (graph[u][v] != 0 && mstSet[v] == false
                    && graph[u][v] < key[v]) {
                  
                    parent[v] = u;
                    key[v] = graph[u][v];
                 
                }
               
            }
        }
        
        // Print the constructed MST
        printMST(parent, key);
    }

    public static void main(String[] args)
    {
        Prims t = new Prims();
        int graph[][] =             { { 0, 2, 0, 6, 0 },
                                      { 2, 0, 3, 8, 5 },
                                      { 0, 3, 0, 0, 7 },
                                      { 6, 8, 0, 0, 6 },
                                      { 0, 5, 7, 6, 0 } };

        // Print the solution

        t.primMST(graph);
    }
}