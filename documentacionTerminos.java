
package proyecto;

import java.util.ArrayList;

/*
 * Documentacion Basica de Terminos de Programacion Usados en el Proyecto
 * Este archivo sirve como referencia rapida.
 */
public class documentacionTerminos {
    
    /* ----------------------------------
     * CONCEPTOS DE PROGRAMACION ORIENTADA A OBJETOS (POO)
     * ---------------------------------- */

    /*
     * ARRAYS (Arreglos o Vectores):
     * Son estructuras de datos que permiten almacenar multiples valores del MISMO TIPO de dato
     * bajo un unico nombre de variable. Tienen un tamaño fijo que no cambia.
     * En nuestro proyecto se usan para guardar usuarios, contraseñas, nombres de productos y precios.
     */
    private static String[] ejemploArrayNombres = {"Admin", "Pedro", "Carlos"};
    private static double[] ejemploArrayPrecios = {1000.0, 2000.0, 500.0};
    
    /*
     * ATRIBUTOS (Variables de Instancia):
     * Son las variables que definen las caracteristicas o el estado de un objeto.
     * En nuestro proyecto, un Cliente tiene 'nombreCliente', una Factura tiene 'totalFinal', etc.
     */
    private String nombreEjemplo;
    public int edadEjemplo;
    private ArrayList<String> listaEjemplo;

    /*
     * ENCAPSULAMIENTO:
     * Es la practica de ocultar los detalles internos de una clase y proteger sus atributos.
     * Usamos 'private' para que solo los metodos de ESTA clase puedan acceder directamente
     * a los atributos 'nombreEjemplo' y 'listaEjemplo'.
     * Esto evita que otras partes del programa cambien datos de forma inesperada.
     */

    /*
     * CONSTRUCTORES:
     * Son metodos especiales que se ejecutan automaticamente cuando creas un NUEVO objeto (usando 'new').
     * Su trabajo es inicializar el objeto a un estado valido.
     */
    
    // Constructor vacio (sin parametros), inicializa valores por defecto
    public documentacionTerminos() {
        this.nombreEjemplo = "Sin Nombre";
        this.edadEjemplo = 0;
        this.listaEjemplo = new ArrayList<>();
    }

    // Constructor completo (recibe parametros), inicializa valores especificos
    public documentacionTerminos(String nombre, int edad) {
        this.nombreEjemplo = nombre;
        this.edadEjemplo = edad;
        this.listaEjemplo = new ArrayList<>();
    }
    
    /*
     * METODOS (Funciones de Instancia):
     * Son las acciones que un objeto puede realizar. Definen el comportamiento de la clase.
     * En nuestro proyecto, tenemos metodos como 'realizarCompra()', 'generarFactura()', 'gestionAccesos()'.
     */
    public void saludar() {
        System.out.println("Hola, mi nombre es " + this.nombreEjemplo);
    }

    /*
     * PROPIEDADES (Getters y Setters):
     * Son metodos publicos que nos permiten acceder (GET) o modificar (SET)
     * los atributos privados de forma controlada, respetando el encapsulamiento.
     */
    
    // Getter (obtiene el valor del atributo privado 'nombreEjemplo')
    public String getNombreEjemplo() {
        return this.nombreEjemplo;
    }
    
    // Setter (establece el valor del atributo privado 'nombreEjemplo', opcionalmente con validacion)
    public void setNombreEjemplo(String nuevoNombre) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombreEjemplo = nuevoNombre;
        }
    }


    /*
     * LLAMAR CLASES DESDE OTRA CLASE (Instanciar Objetos y Usarlos):
     * Es como interactuan las diferentes partes del proyecto.
     * En 'Cliente.java' creamos un objeto 'Factura' para procesar el pedido.
     */
    public void ejemploLlamarClases() {
        // Creamos una instancia de otra clase (asumiendo que existe la clase 'Cliente' en el mismo paquete)
        // Esto crea un objeto 'miCliente' usando el constructor vacio de la clase Cliente
        Cliente miCliente = new Cliente(); 
        
        // Usamos un metodo del objeto que acabamos de crear
        miCliente.agregarProducto("Cafe");
       // System.out.println("El total del cliente es: " + miCliente.calcularTotal());
    }
    
    
    
    /* ----------------------------------
     * ESTRUCTURAS DE CONTROL DE FLUJO
     * (El resto de codigo de control de flujo se mantiene igual que antes)
     * ---------------------------------- */

    public void ejemplosDeControlDeFlujo() {
        // ... [Contenido de if, for, while, do-while, try-catch sigue aqui] ...
        
        /*
         * IF / ELSE IF / ELSE:
         * Se usan para tomar decisiones. El codigo dentro del 'if' se ejecuta SOLO si la condicion es verdadera (true).
         * 'else if' revisa una segunda condicion si la primera fallo.
         * 'else' se ejecuta si todas las condiciones anteriores fallaron.
         */
        int edad = 18;
        if (edad >= 18) {
            System.out.println("Es mayor de edad.");
        } else if (edad >= 13) {
            System.out.println("Es adolescente.");
        } else {
            System.out.println("Es un niño.");
        }

        /*
         * SWITCH:
         * Es una forma mas limpia de manejar multiples opciones basadas en una sola variable (como numeros enteros o Strings).
         */
        int opcionMenu = 2;
        switch (opcionMenu) {
            case 1:
                System.out.println("Selecciono la opcion 1.");
                break;
            case 2:
                System.out.println("Selecciono la opcion 2.");
                break;
            default:
                System.out.println("Opcion no valida.");
        }

        /*
         * FOR (Bucle 'para'):
         * Se usa para repetir un bloque de codigo un numero ESPECIFICO y conocido de veces.
         */
        String[] productos = {"Pizza", "Tacos", "Soda"};
        for (int i = 0; i < productos.length; i++) {
            System.out.println("Producto en posicion " + i + ": " + productos[i]);
        }

        /*
         * WHILE (Bucle 'mientras'):
         * Se usa para repetir un bloque de codigo MIENTRAS una condicion sea verdadera.
         */
        int intentosLogin = 0;
        while (intentosLogin < 3) {
            System.out.println("Intento de login numero: " + (intentosLogin + 1));
            intentosLogin++;
        }

        /*
         * DO-WHILE (Bucle 'hacer-mientras'):
         * Se ejecuta AL MENOS UNA VEZ, antes de revisar la condicion.
         * Ideal para menus de opciones.
         */
        int opcionElegida;
        do {
            System.out.println("Menu: 1. Comprar, 0. Salir");
            opcionElegida = 1;
        } while (opcionElegida != 0);

        /*
         * TRY-CATCH:
         * Se usa para prevenir que el programa se cierre si ocurre un error inesperado (excepcion).
         */
        String numeroTexto = "abc";
        try {
            int numero = Integer.parseInt(numeroTexto);
            System.out.println("Numero convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error: No se pudo convertir '"+ numeroTexto +"' a numero.");
        }
    }
}