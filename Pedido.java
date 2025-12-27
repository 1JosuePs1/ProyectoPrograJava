package proyecto;

import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Pedido {
    // Atributos
    private String fechaPedido;
    private List<String> listaDelPedido;
    private String nombreSucursal;
    private String estadoPedido;
    private String nombreProveedor;
    private int idProveedor;

    // Relaciones
    private Proveedor proveedor;
    private Colaborador colaborador;
    private String nombreCliente;

    // Constructor con parámetros
    public Pedido(String fechaPedido, String nombreSucursal, String nombreProveedor, int idProveedor, Proveedor proveedor, Colaborador colaborador) {     
        this.fechaPedido = fechaPedido;
        this.nombreSucursal = nombreSucursal;
        this.nombreProveedor = nombreProveedor;
        this.idProveedor = idProveedor;
        this.proveedor = proveedor;
        this.colaborador = colaborador;
        this.listaDelPedido = new ArrayList<>();
        this.estadoPedido = "Pendiente"; // Valor por defecto
    }

    
    public void cancelarPedido() {
        this.listaDelPedido.clear();
        this.estadoPedido = "Cancelado";
        System.out.println("Pedido cancelado");
    }

    // Getters y Setters
    public String getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(String fechaPedido) { this.fechaPedido = fechaPedido; }

    public List<String> getListaDelPedido() { return listaDelPedido; }
    public void setListaDelPedido(List<String> listaDelPedido) { this.listaDelPedido = listaDelPedido; }

    public String getNombreSucursal() { return nombreSucursal; }
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = nombreSucursal; }

    public String getEstadoPedido() { return estadoPedido; }
    public void setEstadoPedido(String estadoPedido) { this.estadoPedido = estadoPedido; }

    public String getNombreProveedor() { return nombreProveedor; }
    public void setNombreProveedor(String nombreProveedor) { this.nombreProveedor = nombreProveedor; }

    public int getIdProveedor() { return idProveedor; }
    public void setIdProveedor(int idProveedor) { this.idProveedor = idProveedor; }

    public Proveedor getProveedor() { return proveedor; }
    public void setProveedor(Proveedor proveedor) { this.proveedor = proveedor; }

    public Colaborador getColaborador() { return colaborador; }
    public void setColaborador(Colaborador colaborador) { this.colaborador = colaborador; }
}
