package graph;

import java.util.*;

/**
 * @author Cameron Pascal
 * @author Ari Shaposhnik
 */
public class UndirectedGraph<E> {

    private HashMap<E, LinkedList<E>> adjacencyMap;

    public UndirectedGraph(List<E> vertices) {

        adjacencyMap = new HashMap<E, LinkedList<E>>(vertices.size(), 0.75f);

        for (int i=0; i<vertices.size(); i++) {
            adjacencyMap.put(vertices.get(i), new LinkedList<E>());
        }
    }

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

    public boolean containsVertex(E vertex) {
        return adjacencyMap.containsKey(vertex);
    }

    public String toString() {

        return null;
    }
}
