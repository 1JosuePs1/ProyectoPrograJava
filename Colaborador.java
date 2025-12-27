package proyecto;

/**
 * Representa a un colaborador o empleado de la Soda.
 */
public class Colaborador {
    // Atributos
    private String horarioEntrada;
    private String nombreColaborador;
    private double salario;
    private String puestoColaborador;
    private int telefonoColaborador;
    private int idColaborador;
   

    // Constructor
    public Colaborador(String nombreColaborador, double salario, String puestoColaborador, int idColaborador, int telefonoColaborador, String horarioEntrada) {
        this.nombreColaborador = nombreColaborador;
        this.salario = salario;
        this.puestoColaborador = puestoColaborador;
        this.idColaborador = idColaborador;
        this.telefonoColaborador = telefonoColaborador;
        this.horarioEntrada = horarioEntrada;
    }

    // Métodos
    public void registrarVenta() {
        System.out.println("Colaborador " + nombreColaborador + " registrando una venta.");
    }

    public void realizarPedidos(Pedido pedido) {
        System.out.println("Colaborador " + nombreColaborador + " realizando un pedido.");
    }
    
    public void asignarSucursal(Pedido pedido) {
        System.out.println(" ");
    }
    

    // Getters y Setters
    public String getNombreColaborador() { return nombreColaborador; }
    public void setNombreColaborador(String nombreColaborador) { this.nombreColaborador = nombreColaborador; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }

    public String getPuestoColaborador() { return puestoColaborador; }
    public void setPuestoColaborador(String puestoColaborador) { this.puestoColaborador = puestoColaborador; }

    public int getIdColaborador() { return idColaborador; }
    public void setIdColaborador(int idColaborador) { this.idColaborador = idColaborador; }
    
    public int getTelefonoColaborador() { return telefonoColaborador; }
    public void setTelefonoColaborador(int telefonoColaborador) { this.telefonoColaborador = telefonoColaborador; }

    public String getHorarioEntrada() { return horarioEntrada; }
    public void setHorarioEntrada(String horarioEntrada) { this.horarioEntrada = horarioEntrada; }
}
