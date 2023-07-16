import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase ManejoArticulos que permite crear, consultar, listar, modificar y eliminar clientes.
 */
public class ManejoArticulos {

    // Variables para la lectura de entrada por consola
    private InputStreamReader isr;
    private BufferedReader br;
    // Mapa para almacenar los clientes
    private Map<Integer, Articulo> mapaManejoArticulos;

    /**
     * Constructor de la clase que inicializa las variables y llama al método menu.
     */
    public ManejoArticulos() {
        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);
        mapaManejoArticulos = new HashMap<>();
        menu();
    }

    /**
     * Método que muestra el menú principal y permite realizar las distintas acciones relacionadas con los articulos.
     */
    private void menu() {
        int opcion = 0;
        do {
            System.out.println("\n\nMENU PRINCIPAL\n");
            System.out.println("1. Crear articulo");
            System.out.println("2. Consultar por identificacion");
            System.out.println("3. Listar articulos");
            System.out.println("4. Modificar articulo");
            System.out.println("5. Eliminar articulo");
            System.out.println("6. Salir");
            opcion = capturarEntero("ALTERNATIVA");
            switch (opcion) {
                case 1 -> crearArticulo();
                case 2 -> consultarPorIdentificacion();
                case 3 -> listarArticulo();
                case 4 -> modificarArticulo();
                case 5 -> eliminarArticulo();
                case 6 -> System.out.println("se acabo");
                default -> System.out.println("ingrese un numero entre los rangos del 1 al  6");
            }
        } while (opcion >= 0 && opcion <= 5);
    }

    /**
     * Método para eliminar un articulo en el sistema
     */
    private void eliminarArticulo() {
        System.out.println("\nELIMINAR ARTICULO\n");
        int idArticulo = capturarEntero("Ingrese identificacion");
        // Verificar si la identificacion ingresada existe en el mapa
        if (mapaManejoArticulos.containsKey(idArticulo)) {
            // Eliminar ARTICULO
            mapaManejoArticulos.remove(idArticulo);
        } else {
            System.out.println("Identificacion no existe en el sistema");
        }
    }

    /**
     * Método para modificar la información de un cliente en el sistema
     */
    private void modificarArticulo() {
        System.out.println("\nMODIFICAR ARTICULO\n");
        int idArticulo = capturarEntero("Ingrese identificacion");
        // Verificar si la identificacion ingresada existe en el mapa
        if (mapaManejoArticulos.containsKey(idArticulo)) {
            Articulo articulo = null;
            System.out.println("\nDATOS ACTUALES: ");
            articulo = mapaManejoArticulos.get(idArticulo);
            System.out.println(articulo);
            System.out.println("\nNUEVOS DATOS: ");
            String ingreseNuevoNombre = capturarCadena("Ingrese nuevo nombre");
            int ingreseNuevaCantidad = Integer.parseInt(capturarCadena("Ingrese nueva cantidad"));
            float ingreseNuevaCosto = Integer.parseInt(capturarCadena("Ingrese nuevo costo"));
            // Modificar la información del articulo
            articulo.setNombreArticulo(ingreseNuevoNombre);
            articulo.setCantArticulo(ingreseNuevaCantidad);
            articulo.setCostoArticulo(ingreseNuevaCosto);
            // Actualizar el mapa con la información modificada del articulo
            mapaManejoArticulos.put(idArticulo, articulo);
        } else {
            System.out.println("Identificacion no existe en el sistema");
        }
    }

    /**
     * Método para listar todos los clientes registrados en el sistema
     */
    private void listarArticulo() {
        System.out.println("\nLISTA DE CLIENTES\n");
        // Obtener el conjunto de claves en el mapa de manejo de clientes
        Iterator<Integer> keys = mapaManejoArticulos.keySet().iterator();
        int cont = 0;
        // Recorrer el conjunto de claves
        while (keys.hasNext()) {
            cont++;
            Integer clave = keys.next();
            // Imprimir la información del cliente correspondiente a la clave
            System.out.println(mapaManejoArticulos.get(clave));
        }
        if (cont == 0) {
            System.out.println("\n*** No hay clientes registrados ***\n");
        }
    }

    /**
     * Método para consultar un cliente en el sistema a partir de su identificación
     */
    private void consultarPorIdentificacion() {
        System.out.println("\nCONSULTAR POR IDENTIFICACION\n");
        // Capturar la identificación del cliente a consultar
        Integer idArticulo = capturarEntero("Ingrese identificacion");
        // Verificar si existe un cliente con la identificación especificada
        if (mapaManejoArticulos.containsKey(idArticulo)) {
            // Imprimir la información del cliente
            System.out.println("Datos del Articulo: ");
            System.out.println(mapaManejoArticulos.get(idArticulo));
        } else {
            // En caso de que no exista un cliente con la identificación especificada, imprimir un mensaje de error
            System.out.println("Identificacion no existe en el sistema");
        }
    }

    /**
     * Método para crear un nuevo cliente en el sistema
     */
    private void crearArticulo() {
        System.out.println("\nCREAR ARTICULO\n");
        // Capturar la identificación del cliente
        int idArticulo = capturarEntero("Ingrese identificacion");
        // Verificar si existe un cliente con la identificación especificada
        if (this.mapaManejoArticulos.containsKey(idArticulo)) {
            // En caso de que ya exista un cliente con la identificación especificada, imprimir un mensaje de error
            System.out.println("Error, numero de identificacion ya existe");
        } else {
            // Capturar los datos del cliente
            String nombreArticulo=capturarCadena("ingrese el nombre del articulo");
            int cantArticulo=capturarEntero("ingrese la cantidad del articulo");
            float costoArticulo=capturarEntero("ingrese el costo del articulo");
            // Crear un objeto de tipo Cliente con los datos capturados
            Articulo articulo = new Articulo(idArticulo,nombreArticulo,cantArticulo,costoArticulo);
            // Agregar el cliente al mapa de manejo de clientes
            mapaManejoArticulos.put(idArticulo, articulo);
        }
    }

    /**
     * Método para capturar un valor entero de la entrada del usuario
     *
     * @param texto una cadena que se muestra como una solicitud para que el usuario ingrese el número entero
     * @return un valor entero capturado del usuario
     */
    private Integer capturarEntero(String texto) {
        Integer resp = 0;
        try {
            // Imprime el mensaje y lee la entrada del usuario
            System.out.print(texto + ": ");
            String aux = br.readLine();
            // Analiza la entrada del usuario como un entero
            resp = Integer.parseInt(aux);
        } catch (Exception ex) {
            // En caso de que la entrada del usuario no sea un entero válido, se muestra un mensaje de error
            System.out.println("Error, ingrese un valor entero");
        }
        return resp;
    }

    /**
     * Captura una cadena de texto ingresada por el usuario.
     *
     * @param texto el texto a mostrar al usuario
     * @return la cadena de texto ingresada por el usuario
     */
    private String capturarCadena(String texto) {
        try {
            System.out.print(texto + ": ");
            String aux = br.readLine();
            return aux;

        } catch (IOException ex) {
            Logger.getLogger(ManejoArticulos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

