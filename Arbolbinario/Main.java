    public class Main {
        public static void main(String[] args) {
            ArbolBinario arbolBinario= new ArbolBinario();
            // Generación 1
            arbolBinario.agregarNodo(1,"papabisabueloP");
            arbolBinario.agregarNodo(1,"papabisabuelaP");
            arbolBinario.agregarNodo(1,"papabisabueloM");
            arbolBinario.agregarNodo(1,"papabisabuelaM");
            arbolBinario.agregarNodo(1,"mamabisabueloP");
            arbolBinario.agregarNodo(1, "mamabisabuelaP");
            arbolBinario.agregarNodo(1, "mamabisabueloM");
            arbolBinario.agregarNodo(1, "mamabisabuelaM");

            // Generación 2
            arbolBinario.agregarNodo(2, "abueloP");
            arbolBinario.agregarNodo(2, "abuelaP");
            arbolBinario.agregarNodo(2, "MAMI");
            arbolBinario.agregarNodo(2, "PAPI");



            // Generación 3
            arbolBinario.agregarNodo(3,"JOHANNA FERNANDA MURCIA ACERO");
            arbolBinario.agregarNodo(3, "CENARDO ELAIS BANGUERO CUENCA");

            // Generación 4
            arbolBinario.agregarNodo(4, "ANDRES MAURICIO BANGUERO MURCIA");
            arbolBinario.agregarNodo(4, "KEVIN SANTIAGO BANGUERO MURCIA");
            arbolBinario.agregarNodo(4, "MARTIN ELIAS BANGUERO MURCIA");
            arbolBinario.imprimirArbol();//indices ordenados de menor a mayor generacion
        }
    }
