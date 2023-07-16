import java.util.*;
public class ManejoArticulos {
    private final Stack<Articulo> inventario;

    public ManejoArticulos() {
        inventario = new Stack<>();
    }

    public void menu() {
        int opcion;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMENÚ PRINCIPAL\n");
            System.out.println("1. Agregar Artículo");
            System.out.println("2. Buscar Artículo");
            System.out.println("3. Listar Artículos");
            System.out.println("4. Eliminar Artículo");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> agregarArticulo();
                case 2 -> buscarArticulo();
                case 3 -> listarArticulos();
                case 4 -> eliminarArticulo();
                case 5 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (opcion != 5);
    }

    private void agregarArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nAGREGAR ARTÍCULO\n");
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();

        if (existeArticulo(id)) {
            System.out.println("Ya existe un artículo con el mismo ID.");
            return;
        }

        System.out.print("Ingrese el Nombre: ");
        String nombre = scanner.next();

        System.out.print("Ingrese la Cantidad: ");
        int cantidad = scanner.nextInt();

        System.out.print("Ingrese el Costo: ");
        float costo = scanner.nextFloat();

        Articulo articulo = new Articulo(id, nombre, cantidad, costo);
        inventario.push(articulo);
        System.out.println("Artículo agregado correctamente.");
    }

    private void buscarArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBUSCAR ARTÍCULO\n");
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();

        Articulo articuloEncontrado = obtenerArticuloPorId(id);

        if (articuloEncontrado != null) {
            System.out.println("Artículo encontrado:");
            System.out.println(articuloEncontrado);
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private void listarArticulos() {
        System.out.println("\nLISTAR ARTÍCULOS\n");

        if (inventario.isEmpty()) {
            System.out.println("No hay artículos en el inventario.");
        } else {
            for (Articulo articulo : inventario) {
                System.out.println(articulo);
            }
        }
    }

    private void eliminarArticulo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nELIMINAR ARTÍCULO\n");
        System.out.print("Ingrese el ID: ");
        int id = scanner.nextInt();

        Articulo articuloEncontrado = obtenerArticuloPorId(id);

        if (articuloEncontrado != null) {
            inventario.remove(articuloEncontrado);
            System.out.println("Artículo eliminado correctamente.");
        } else {
            System.out.println("Artículo no encontrado.");
        }
    }

    private boolean existeArticulo(int id) {
        for (Articulo articulo : inventario) {
            if (articulo.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private Articulo obtenerArticuloPorId(int id) {
        for (Articulo articulo : inventario) {
            if (articulo.getId() == id) {
                return articulo;
            }
        }
        return null;
    }
}