package proyecto;

/**
 * proveedor que suministra productos a la Soda.
 */
public class Proveedor {
    // Atributos
    private int telefonoProveedor;
    private String nombreProveedor;
    private String correoProveedor;
    private String productos;
    private String idProveedor;

    // Constructor
    public Proveedor(int telefonoProveedor, String nombreProveedor, String correoProveedor, String productos, String idProveedor) {
        this.telefonoProveedor = telefonoProveedor;
        this.nombreProveedor = nombreProveedor;
        this.correoProveedor = correoProveedor;
        this.productos = productos;
        this.idProveedor = idProveedor;
    }

    // Métodos
    public void entregarPedido(Pedido pedido) {
        System.out.println(" Entregando pedido a la sucursal: " + pedido.getNombreSucursal());
        System.out.println(" Estado actual del pedido: " + pedido.getEstadoPedido());
    }

    public void revisionDeEntrega() {
        System.out.println(" Revisando la entrega del pedido.");
    }

    public void actualizarDatos() {
        System.out.println(" Actualizando los datos del proveedor: " + nombreProveedor);
    }

    public void realizarCotizaciones() {
        System.out.println(" Generando cotizaciones de productos.");
    }

    // Getters y Setters
    public int getTelefonoProveedor() { return telefonoProveedor; }
    public void setTelefonoProveedor(int telefonoProveedor) { this.telefonoProveedor = telefonoProveedor; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public String getCorreoProveedor() { return correoProveedor; }
    public void setCorreoProveedor(String correoProveedor) { this.correoProveedor = correoProveedor; }

    public String getProductos() { return productos; }
    public void setProductos(String productos) { this.productos = productos; }

    public String getIdProveedor() { return idProveedor; }
    public void setIdProveedor(String idProveedor) { this.idProveedor = idProveedor; }
}
