/*import java.util.*;

public class Main {

    public static void main(String[] args) {

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        dijkstra.addRoute("Ibague", "Girardot", 71.2);
        dijkstra.addRoute("Girardot", "Anapoima", 53.4);
        dijkstra.addRoute("Anapoima", "Funza", 71.3);
        dijkstra.addRoute("Funza", "Bogota", 22.4);


        DijkstraAlgorithm dijkstra2 = new DijkstraAlgorithm();
        dijkstra2.addRoute("Ibague", "Girardot", 71.2);
        dijkstra2.addRoute("Girardot", "Melgar", 33.8);
        dijkstra2.addRoute("Melgar", "Fugasuga", 46.1);
        dijkstra2.addRoute("Fugasuga", "Silvana", 11.4);
        dijkstra2.addRoute("Silvana", "Sibate", 43.7);
        dijkstra2.addRoute("Sibate", "Soacha", 13.4);
        dijkstra2.addRoute("Soacha", "Bogota", 24.7);

        DijkstraAlgorithm dijkstra3 = new DijkstraAlgorithm();
        dijkstra3.addRoute("Ibague", "Alvarado", 42.3);
        dijkstra3.addRoute("Alvarado", "Venadillo", 56.3);
        dijkstra3.addRoute("Venadillo", "Facativa", 147.8);
        dijkstra3.addRoute("Facativa", "Funza", 27.1);
        dijkstra3.addRoute("Funza", "Bogota", 22.4);

        List<String> shortestPath1 = dijkstra.findShortestPath("Ibague", "Bogota");
        List<String> shortestPath2 = dijkstra2.findShortestPath("Ibague", "Bogota");
        List<String> shortestPath3 = dijkstra3.findShortestPath("Ibague", "Bogota");

        double totalDistance1 = calculateTotalDistance(dijkstra, shortestPath1);
        double totalDistance2 = calculateTotalDistance(dijkstra2, shortestPath2);
        double totalDistance3 = calculateTotalDistance(dijkstra3, shortestPath3);

        System.out.println("Camino 1: " + shortestPath1 + ", Distancia total: " + totalDistance1);
        System.out.println("Camino 2: " + shortestPath2 + ", Distancia total: " + totalDistance2);
        System.out.println("Camino 3: " + shortestPath3 + ", Distancia total: " + totalDistance3);

        if (totalDistance1 <= totalDistance2 && totalDistance1 <= totalDistance3) {
            System.out.println("El camino 1 es el más corto.");
        } else if (totalDistance2 <= totalDistance1 && totalDistance2 <= totalDistance3) {
            System.out.println("El camino 2 es el más corto.");
        } else {
            System.out.println("El camino 3 es el más corto.");
        }
    }

    private static double calculateTotalDistance(DijkstraAlgorithm dijkstra, List<String> path) {
        double totalDistance = 0.0;

        if (path != null) {
            for (int i = 0; i < path.size() - 1; i++) {
                String current = path.get(i);
                String next = path.get(i + 1);

                Map<String, Double> neighbors = dijkstra.getGraph().get(current);

                if (neighbors != null) {
                    Double distance = neighbors.get(next);

                    if (distance != null) {
                        totalDistance += distance;
                    }
                }
            }
        }

        return totalDistance;
    }
}*/
import java.util.*;

public class Main {

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();

        // Agregar las rutas al grafo (asegurarse de que los nombres estén en minúsculas)
        dijkstra.addRoute("ibague", "girardot", 71.2);
        dijkstra.addRoute("girardot", "anapoima", 53.4);
        dijkstra.addRoute("anapoima", "funza", 71.3);
        dijkstra.addRoute("funza", "bogota", 22.4);
        dijkstra.addRoute("ibague", "melgar", 33.8);
        dijkstra.addRoute("melgar", "fugasuga", 46.1);
        dijkstra.addRoute("fugasuga", "silvana", 11.4);
        dijkstra.addRoute("silvana", "sibate", 43.7);
        dijkstra.addRoute("sibate", "soacha", 13.4);
        dijkstra.addRoute("soacha", "bogota", 24.7);
        dijkstra.addRoute("ibague", "alvarado", 42.3);
        dijkstra.addRoute("alvarado", "venadillo", 56.3);
        dijkstra.addRoute("venadillo", "facativa", 147.8);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el destino: ");
        String destino = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

        List<String> shortestPath = dijkstra.findShortestPath("ibague", destino);

        if (shortestPath != null) {
            double totalDistance = calculateTotalDistance(dijkstra, shortestPath);
            System.out.println("El camino más corto hacia " + destino + " es: " + shortestPath + ", Distancia total: " + totalDistance);
        } else {
            System.out.println("No se encontró un camino válido hacia " + destino);
        }
    }

    private static double calculateTotalDistance(DijkstraAlgorithm dijkstra, List<String> path) {
        double totalDistance = 0.0;

        for (int i = 0; i < path.size() - 1; i++) {
            String current = path.get(i);
            String next = path.get(i + 1);

            Map<String, Double> neighbors = dijkstra.getGraph().get(current);

            if (neighbors != null) {
                Double distance = neighbors.get(next);

                if (distance != null) {
                    totalDistance += distance;
                }
            }
        }

        return totalDistance;
    }
}
