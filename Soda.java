package proyecto;

import javax.swing.JOptionPane;

public class Soda {

    /* Atributos para el manejo de usuarios:
    * Se usan arreglos para guardar los usuarios y contraseñas permitidos.
    * El 'usuarioActual' guarda quien inicio sesion correctamente.
    */
    private String[] usuarios = {"Admin", "Pedro", "Carlos"};
    private String[] contra = {"1234", "abcd", "pass"};
    private String usuarioActual;

    /* Datos basicos de la soda:
    * Variables que guardan informacion general del negocio y del usuario logeado (excepto para el constructor vacio).
    */
    private String nombreSoda;
    private String puestoUsuario;
    private int idUsuario;
    private int telefonoUsuario;
    private String nombreSucursal;
    private String horario;

    /* Constructores:
    * El primero es un constructor completo para inicializar todos los datos de la soda/usuario.
    * El segundo es un constructor vacio por si se necesita crear el objeto sin datos iniciales.
    */
    public Soda(String nombreSoda, String puestoUsuario, int idUsuario, int telefonoUsuario, String nombreSucursal, String horario) {
        this.nombreSoda = nombreSoda;
        this.puestoUsuario = puestoUsuario;
        this.idUsuario = idUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.nombreSucursal = nombreSucursal;
        this.horario = horario;
    }

    public Soda() {
    }

    /* Metodo de gestion de accesos:
    * Se encarga de pedir usuario y contraseña, validar contra los arreglos,
    * y limitar los intentos de acceso a 3 veces antes de denegar la entrada.
    * Devuelve 'true' si el acceso es correcto y 'false' si falla.
    */
    public boolean gestionAccesos() {
        int intentos = 0;

        while (intentos < 4) {
            // Si llega al tercer intento fallido, muestra mensaje y sale del metodo
            if (intentos == 3) {
                JOptionPane.showMessageDialog(null, "Acceso denegado. Ha superado el limite de intentos.");
                return false;
            }

            String usuario = JOptionPane.showInputDialog("Ingrese el usuario:");
            String contra2 = JOptionPane.showInputDialog("Ingrese la contraseña:");

            // Recorre los arreglos para buscar una coincidencia de usuario y contra
            for (int i = 0; i < usuarios.length; i++) {
                if (usuario.equals(usuarios[i]) && contra2.equals(contra[i])) {
                    usuarioActual = usuario; // Guarda el usuario que acaba de entrar
                    JOptionPane.showMessageDialog(null, "Acceso concedido a " + usuario);
                    return true; // Acceso correcto, sale del metodo y devuelve true
                }
            }

            // Si no encontro coincidencia en el for, suma un intento fallido y sigue el while
            intentos++;
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos. Intento " + intentos + " de 3.");
        }

        // Si el bucle while termina sin exito (solo pasa si se sale del bucle por alguna razon inesperada), devuelve false
        return false;
    }

    /* Menu PRINCIPAL:
    * Muestra diferentes opciones dependiendo de si el usuario logeado es "Admin" o un cliente/empleado normal.
    * Usa un bucle 'do-while' para mostrar el menu repetidamente hasta que el usuario elija salir (opcion 0).
    */
    public void ingresarOpciones() {
        int opcion = 0;

        // Si el usuario es administrador "admin" sale este menu
        if ("Admin".equalsIgnoreCase(usuarioActual)) {
            do {
                /* El 'try-catch' adentro de un do while se usa para manejar errores si el usuario no ingresa un numero valido.
                * 'try' intenta ejecutar el codigo.
                * 'catch (NumberFormatException e)' atrapa el error si la conversion falla,
                * evitando que el programa se cierre inesperadamente y mostrando un mensaje de error amigable.
                */
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(
                            "Bienvenido ADMIN al sistema de la soda\n\n"
                            + "1. Cambiar nombre del restaurante\n"
                            + "2. Editar menu de productos\n"
                            + "3. Gestion de usuarios\n"
                            + "0. Salir\n\n"
                            + "Seleccione una opcion:"));
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido.");
                }
            } while (opcion != 0);

        } else {
            // Si es cliente/empleado (cualquier otro usuario que no sea Admin)
            do {
                try {
                    opcion = Integer.parseInt(JOptionPane.showInputDialog(
                            "Bienvenido " + usuarioActual + " al sistema de la soda\n\n"
                            + "1. Hacer pedido\n"
                            + "2. Cerrar sesion\n"
                            + "0. Salir\n\n"
                            + "Seleccione una opcion:"));

                    switch (opcion) {
                        case 1 -> {
                            Cliente cliente = new Cliente(); // Se crea un nuevo objeto Cliente para manejar el pedido
                            cliente.realizarCompra();
                        }
                        case 2 -> {
                            JOptionPane.showMessageDialog(null, "Cerrando sesion...");
                            if (gestionAccesos()) { // Vuelve a pedir login.
                                ingresarOpciones(); 
                            }
                            return; // sale
                        }
                        case 0 ->
                            JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                        default ->
                            JOptionPane.showMessageDialog(null, "Opcion no valida.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido.");
                }
            } while (opcion != 0);
        }
    }


    public void gestionUsuarios() {
        System.out.println("-> Gestion de usuarios");
    }

   
    public String getNombreSoda() { return nombreSoda; }
    public void setNombreSoda(String nombreSoda) { this.nombreSoda = nombreSoda; }

    public String getPuestoUsuario() { return puestoUsuario; }
    public void setPuestoUsuario(String puestoUsuario) { this.puestoUsuario = puestoUsuario; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public int getTelefonoUsuario() { return telefonoUsuario; }
    public void setTelefonoUsuario(int telefonoUsuario) { this.telefonoUsuario = telefonoUsuario; }

    public String getNombreSucursal() { return nombreSucursal; }
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = nombreSucursal; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
