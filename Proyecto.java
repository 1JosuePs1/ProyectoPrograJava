package proyecto;

public class Proyecto {
    
    public static void main(String[] args) {
        
        // Creamos un objeto de la clase Soda con informacion basica
        // objeto de soda con info, no tiene funcion de logica por ahora, solo guarda los datos de la soda
        Soda miSoda = new Soda("Soda La Esquina", "Encargado", 101, 88885555, "Sucursal Central", "San Jose centro");

        //llama al login
        if (miSoda.gestionAccesos()) {
            // si el login es exitoso (devuelve true), pasa al menu principal de opciones
            miSoda.ingresarOpciones();
        } else {
            // Si falla el login devuelve false, se deniega el acceso y el programa termina
            System.out.println("Acceso denegado. Cerrando aplicacion.");
        }
    }
}
