package proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Cliente {

    // Atributos del cliente
    private String nombreCliente;
    private String telefonoCliente;
    private int cedulaCliente;
    private String correoCliente;
    private String registroCliente;

    // Pedido del cliente
    private ArrayList<String> listaDelPedido = new ArrayList<>();
    private String estadoPedido;

    // Constructor completo
    public Cliente(String nombreCliente, String telefonoCliente, String correoCliente, int cedulaCliente, String registroCliente) {
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.cedulaCliente = cedulaCliente;
        this.registroCliente = registroCliente;
        this.listaDelPedido = new ArrayList<>();
        this.estadoPedido = "Pendiente";
    }

    // Constructor vacío
    public Cliente() {
        this.listaDelPedido = new ArrayList<>();
        this.estadoPedido = "Pendiente";
    }

    
    
    /**
     * guia al usuario a traves del proceso de seleccion de productos utilizando
     * dialogos de JOptionPane. Permite añadir hasta 10 productos a la lista de pedidos.
     */
    public void realizarCompra() {
        // Obtener los datos disponibles de productos y precios desde la clase estatica Producto
        String[] nombresProducto = Producto.getNombreProducto();
        double[] preciosProducto = Producto.getPrecioProducto();

        // Validar si ya se alcanzo el limite maximo de productos permitidos (10)
        if (listaDelPedido.size() >= 10) {
            JOptionPane.showMessageDialog(null, "Ya alcanzaste el maximo de 10 productos.");
            return; // Salir del metodo si el limite esta lleno
        }

        // Preparar las opciones que se mostraran en el dialogo (Nombre - ₡Precio)
        Object[] opciones = new Object[nombresProducto.length];
        for (int i = 0; i < nombresProducto.length; i++) {
            opciones[i] = nombresProducto[i] + " - ₡" + preciosProducto[i];
        }

        boolean seguir = true; // Variable de control para el bucle de seleccion

        // Bucle principal para añadir productos mientras el usuario quiera y no exceda el limite
        while (seguir && listaDelPedido.size() < 10) {
            // Mostrar dialogo con opciones de productos disponibles
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona un producto",
                    "Menu de la Soda",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            // Manejar caso donde el usuario cierra el dialogo sin seleccionar nada
            if (seleccion == -1) {
                JOptionPane.showMessageDialog(null, "No seleccionaste nada");
                continue; // Volver a mostrar el menu
            }

            // Añadir el producto seleccionado a la lista del pedido
            listaDelPedido.add(nombresProducto[seleccion]);
            
            // Informar al usuario que el producto fue añadido exitosamente
            JOptionPane.showMessageDialog(null,
                    "Agregado: " + nombresProducto[seleccion] +
                    " por ₡" + preciosProducto[seleccion] +
                    "\n\nProductos en orden: " + listaDelPedido.size() + "/10" // Mostrar progreso
            );

            // Preguntar si desea añadir otro producto o finalizar la compra (totalizar)
            int opcionFinal = JOptionPane.showOptionDialog(
                    null,
                    "¿Deseas agregar otro producto?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new String[]{"Agregar otro", "Totalizar"}, // Opciones personalizadas
                    "Agregar otro"
            );

            // Si selecciona "Totalizar" (opcionFinal == 1), terminar el bucle
            if (opcionFinal == 1) {
                seguir = false;
            }
        }

        //  Fase de Facturacion 

        // Crear una instancia de factura con los datos recopilados
        Factura factura = new Factura(listaDelPedido);

        // Pasar los arreglos completos de productos y precios a la factura para que pueda calcular totales
        factura.setDatosPedido(listaDelPedido, nombresProducto, preciosProducto);

        // Generar y mostrar la factura final al usuario
        factura.generarFactura();
    }

    // agrega productos a la lista
    public void agregarProducto(String producto) {
        this.listaDelPedido.add(producto);
    }

    // Solicitar factura (solo mensaje)
    public void solicitarFactura(Factura factura) {
        System.out.println("Solicitando factura para la compra.");
    }

    // Getters y Setters
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getTelefonoCliente() { return telefonoCliente; }
    public void setTelefonoCliente(String telefonoCliente) { this.telefonoCliente = telefonoCliente; }

    public int getCedulaCliente() { return cedulaCliente; }
    public void setCedulaCliente(int cedulaCliente) { this.cedulaCliente = cedulaCliente; }

    public String getCorreoCliente() { return correoCliente; }
    public void setCorreoCliente(String correoCliente) { this.correoCliente = correoCliente; }

    public String getRegistroCliente() { return registroCliente; }
    public void setRegistroCliente(String registroCliente) { this.registroCliente = registroCliente; }
}
