package graph;

import java.util.*;

/**
 * Basic implementation of an undirected graph using a hash map as the underlying adjacency structure.
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class UndirectedGraph<E> {

    private HashMap<E, LinkedList<E>> adjacencyMap;

    /**
     * Instantiates a graph of vertices with no edges.
     * @param vertices List of vertices to be contained in the graph.
     */
    public UndirectedGraph(List<E> vertices) {

        // Load factor can be adjusted as necessary.
        adjacencyMap = new HashMap<E, LinkedList<E>>(vertices.size(), 0.75f);

        for (E vertex : vertices) {
            adjacencyMap.put(vertex, new LinkedList<E>());
        }
    }

    /**
     * Adds and edge between specified vertices.
     * @param vertexA First vertex.
     * @param vertexB Second vertex.
     * @throws IllegalArgumentException if at least one specified vertex is not contained in this graph.
     */
    public void addEdge(E vertexA, E vertexB) throws IllegalArgumentException {

        if (!adjacencyMap.containsKey(vertexA) || !adjacencyMap.containsKey(vertexB)) {
           throw new IllegalArgumentException("At least one vertex is not contained in the graph.");
        }

        LinkedList<E> a = adjacencyMap.get(vertexA);
        a.add(vertexB);

        LinkedList<E> b = adjacencyMap.get(vertexB);
        b.add(vertexA);

        adjacencyMap.put(vertexA, a);
        adjacencyMap.put(vertexB, b);
    }

    /**
     * Checks if a given vertex is in this graph.
     * @param vertex The vertex to be checked against this graph.
     * @return <code>true</code> if vertex is contained in this graph, otherwise <code>false</code>.
     */
    public boolean containsVertex(E vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    /**
     * Constructs a string representation of the graph in the format of the input file.
     * @return String representation of the graph.
     */
    public String toString() {

        return null;
    }
}
