package proyecto;

public class Producto {
    // Atributos
    
    //lista con los productos y precios que se envian a la clase Cliente
    private static String[] nombreProducto = {
        "Pizza",
        "Hamburguesa",
        "Flautas",
        "Tacos",
        "Coca Cola",
        "Fanta Naranja",
        "Ginger Ale"
    };

    private static double[] precioProducto = {
        3900,
        1500,
        1000,
        900,
        700,
        700,
        700
    };

    private int cantidadDisponible;
    private String categoriaProducto;
    private String descripcionProducto;

    // Constructor
    public Producto(double precioProducto, String nombreProducto, int cantidadDisponible,
                    String categoriaProducto, String descripcionProducto) {
        this.cantidadDisponible = cantidadDisponible;
        this.categoriaProducto = categoriaProducto;
        this.descripcionProducto = descripcionProducto;
    }

    // Metodos
    public void actualizarInventario() {
        System.out.println("-> Actualizando inventario de: " + nombreProducto);
    }

    public void actualizarPrecio(double nuevoPrecio) {
        System.out.println("-> Precio de " + nombreProducto + " actualizado a: ₡" + nuevoPrecio);
    }

    public void pedirFaltantes() {
        System.out.println("-> Solicitando reabastecimiento del producto: " + nombreProducto);
    }

    // Getters y Setters
    public static double[] getPrecioProducto() { return precioProducto; }
    public static String[] getNombreProducto() { return nombreProducto; }

    public int getCantidadDisponible() { return cantidadDisponible; }
    public void setCantidadDisponible(int cantidadDisponible) { this.cantidadDisponible = cantidadDisponible; }

    public String getCategoriaProducto() { return categoriaProducto; }
    public void setCategoriaProducto(String categoriaProducto) { this.categoriaProducto = categoriaProducto; }

    public String getDescripcionProducto() { return descripcionProducto; }
    public void setDescripcionProducto(String descripcionProducto) { this.descripcionProducto = descripcionProducto; }
}
