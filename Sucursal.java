package proyecto;

import java.util.List;

/**
 * Representa una de las sucursales de la Soda.
 */
public class Sucursal {
    // Atributos
    private String nombreSucursal;
    private int idSucursal;
    private String direccionSucursal;
    private int telefonoSucursal;
    private String ubicacionSucursal;
    private String horario;

    // Relaciones
    private List<Producto> inventario;
    private List<Colaborador> colaboradores;

    // Constructor
    public Sucursal(String nombreSucursal, int idSucursal, String direccionSucursal,
                    int telefonoSucursal, String ubicacionSucursal, String horario) {
        this.nombreSucursal = nombreSucursal;
        this.idSucursal = idSucursal;
        this.direccionSucursal = direccionSucursal;
        this.telefonoSucursal = telefonoSucursal;
        this.ubicacionSucursal = ubicacionSucursal;
        this.horario = horario;
    }

    // Métodos
    public void registrarInventario() {
        System.out.println(" Registrando inventario en la sucursal: " + nombreSucursal);
    }

    public void ventas() {
        System.out.println(" Registrando ventas en la sucursal: " + nombreSucursal);
    }

    public void pedidos() {
        System.out.println(" Gestionando pedidos en la sucursal: " + nombreSucursal);
    }

    public void contratarColaborador(Colaborador nuevoColaborador) {
        System.out.println(" Contratando nuevo colaborador en " + nombreSucursal);
    }

    // Getters y Setters
    public String getNombreSucursal() { return nombreSucursal; }
    public void setNombreSucursal(String nombreSucursal) { this.nombreSucursal = nombreSucursal; }

    public int getIdSucursal() { return idSucursal; }
    public void setIdSucursal(int idSucursal) { this.idSucursal = idSucursal; }

    public String getDireccionSucursal() { return direccionSucursal; }
    public void setDireccionSucursal(String direccionSucursal) { this.direccionSucursal = direccionSucursal; }

    public int getTelefonoSucursal() { return telefonoSucursal; }
    public void setTelefonoSucursal(int telefonoSucursal) { this.telefonoSucursal = telefonoSucursal; }

    public String getUbicacionSucursal() { return ubicacionSucursal; }
    public void setUbicacionSucursal(String ubicacionSucursal) { this.ubicacionSucursal = ubicacionSucursal; }

    public String getHorario() { return horario; }
    public void setHorario(String horario) { this.horario = horario; }
}
