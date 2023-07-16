import java.util.*;

/**
 * Esta clase representa el algoritmo de Dijkstra, utilizado para encontrar el camino más corto entre dos nodos en un grafo ponderado.
 */
public class DijkstraAlgorithm {
    private final Map<String, Map<String, Double>> graph;

    /**
     * Constructor de la clase que inicializa el grafo como un nuevo objeto HashMap.
     */
    public DijkstraAlgorithm() {
        graph = new HashMap<>();
    }

    /**
     * Agrega una nueva ruta entre dos nodos en el grafo.
     *
     * @param source     El nombre del nodo de origen.
     * @param destination El nombre del nodo de destino.
     * @param distance   La distancia entre el nodo de origen y el nodo de destino.
     */
    public void addRoute(String source, String destination, double distance) {
        graph.computeIfAbsent(source, k -> new HashMap<>()).put(destination, distance);
        graph.computeIfAbsent(destination, k -> new HashMap<>()).put(source, distance);
    }

    /**
     * Devuelve el grafo almacenado en la clase.
     *
     * @return El grafo como un Map donde cada nodo está asociado con sus nodos vecinos y las distancias correspondientes.
     */
    public Map<String, Map<String, Double>> getGraph() {
        return graph;
    }

    /**
     * Busca el camino más corto desde un nodo de inicio hasta un nodo de destino utilizando el algoritmo de Dijkstra.
     *
     * @param start El nombre del nodo de inicio.
     * @param end   El nombre del nodo de destino.
     * @return Una lista de String que representa el camino más corto encontrado. Si no existe un camino válido, retorna null.
     */
    public List<String> findShortestPath(String start, String end) {
        Map<String, Double> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        Set<String> visited = new HashSet<>();

        for (String node : graph.keySet()) {
            distances.put(node, Double.POSITIVE_INFINITY);
        }

        distances.put(start, 0.0);

        while (!visited.contains(end)) {
            String currentNode = findNextNode(distances, visited);
            visited.add(currentNode);

            Map<String, Double> neighbors = graph.get(currentNode);

            if (neighbors != null) {
                for (String neighbor : neighbors.keySet()) {
                    if (!visited.contains(neighbor)) {
                        double currentDistance = distances.get(currentNode);
                        double neighborDistance = neighbors.get(neighbor);
                        double totalDistance = currentDistance + neighborDistance;

                        if (totalDistance < distances.get(neighbor)) {
                            distances.put(neighbor, totalDistance);
                            previousNodes.put(neighbor, currentNode);
                        }
                    }
                }
            }
        }

        return buildPath(previousNodes, start, end);
    }

    /**
     * Método privado utilizado en el algoritmo de Dijkstra para encontrar el próximo nodo a visitar.
     *
     * @param distances Un Map de distancias desde el nodo de inicio a cada nodo.
     * @param visited   Un conjunto de nodos ya visitados.
     * @return El nombre del próximo nodo a visitar.
     */
    private String findNextNode(Map<String, Double> distances, Set<String> visited) {
        double minDistance = Double.POSITIVE_INFINITY;
        String nextNode = null;

        for (Map.Entry<String, Double> entry : distances.entrySet()) {
            String node = entry.getKey();
            double distance = entry.getValue();

            if (!visited.contains(node) && distance < minDistance) {
                minDistance = distance;
                nextNode = node;
            }
        }

        return nextNode;
    }

    /**
     * Método privado utilizado en el algoritmo de Dijkstra para construir el camino más corto encontrado.
     *
     * @param previousNodes Un Map que contiene la relación entre nodos y sus nodos anteriores en el camino más corto.
     * @param start         El nombre del nodo de inicio.
     * @param end           El nombre del nodo de destino.
     * @return Una lista de String que representa el camino más corto encontrado. Si no existe un camino válido, retorna null.
     */
    private List<String> buildPath(Map<String, String> previousNodes, String start, String end) {
        List<String> path = new ArrayList<>();
        String currentNode = end;

        while (currentNode != null) {
            path.add(0, currentNode);
            currentNode = previousNodes.get(currentNode);
        }

        if (!path.get(0).equalsIgnoreCase(start)) {
            return null; // No path found
        }

        return path;
    }
}
