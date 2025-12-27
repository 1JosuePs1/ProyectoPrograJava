package proyecto;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Factura {

    /* Atributos --------------
    Son las variables internas de la clase.
    Guardan el estado u opciones que necesita el objeto para funcionar.
    Ejemplo: listas, nombres, precios, contadores, etc.
    */
    private int numeroFactura;
    private double montoFactura;
    private String metodoPago;
    private int emisionFactura;
    private String nombreCliente;
    private String nombreColaborador;

    private ArrayList<String> listaDelPedido;
    private String[] nombresProducto;
    private double[] preciosProducto;

    private double subtotal;
    private double iva;
    private double totalConIVA;
    private double montoDescuento;
    double totalFinal;

    
    
    /* Constructores ----------
    Son las funciones que se ejecutan cuando se crea un objeto.
    Constructor completo recibe todos los datos necesarios para iniciar la clase.
    Constructor que trae solo el ArrayList (o menos datos sirve para crear el objeto
    e una forma mas simple segun lo que ocupe el programa.
    */
    
    public Factura(ArrayList<String> listaDelPedido1) {
        this.numeroFactura = numeroFactura;
        this.nombreCliente = nombreCliente;
        this.montoFactura = montoFactura;
        this.metodoPago = metodoPago;
        this.emisionFactura = numeroFactura;
        this.nombreColaborador = nombreColaborador;
    }

    
    
    // cargar datos del pedido
    /* este metodo recibe la info que viene de la clase Pedido, como la lista del pedido
    y tambien los arreglos de nombres y precios. esto solo deja todo listo para que
    la factura pueda contar los productos y calcular los montos */

    public void setDatosPedido(ArrayList<String> listaDelPedido,
                               String[] nombresProducto,
                               double[] preciosProducto) {
        this.listaDelPedido = listaDelPedido;
        this.nombresProducto = nombresProducto;
        this.preciosProducto = preciosProducto;
    }

    
    
    
    /* 
    Metodos -------------------
    Son las acciones de la clase.
    Aqui va la logica principal, como procesar datos, contar productos,
    recorrer listas, calcular cantidades o mostrar resultados. 
    */
    
    
    
    // ---------------------- GENERAR FACTURA ----------------------
    /* este metodo arma todo el detalle de la factura, aqui cuento cuantas veces se repite cada producto,
    calculo el precio total, sumo el subtotal, aplico iva y descuento
    al final muestra la factura y pregunta si el cliente quiere pagar */

    public void generarFactura() {

        StringBuilder factura = new StringBuilder("----- FACTURA -----\n\n");
        subtotal = 0;
      

        ArrayList<String> productoProcesado = new ArrayList<>();

        for (int i = 0; i < listaDelPedido.size(); i++) {

            String producto = listaDelPedido.get(i);
            
            // investigue y encontre que .contains()en ves de hacer un for que valide el dato, sirve para revisar si un elemento ya esta en la lista
            // si ya esta, lo ignoro para no contarlo dos veces
            if (productoProcesado.contains(producto)) {
                continue;
            }

            // para contar cuantas veces aparece este producto
            int cantidad = 0;
            for (int j = 0; j < listaDelPedido.size(); j++) {
                if (listaDelPedido.get(j).equals(producto)) {
                    cantidad++;
                }
            }

            double precioUnidad = obtenerPrecio(producto);
            double totalProducto = precioUnidad * cantidad;

            factura.append(cantidad).append(" x ")
                   .append(producto).append(" = ₡")
                   .append(totalProducto).append("\n");

            subtotal += totalProducto;
            productoProcesado.add(producto);
        }

        // Cálculos finales para montar la impresion de la factura
        iva = subtotal * 0.13;
        totalConIVA = subtotal + iva;
        calcularDescuento();

        factura.append("\nSubtotal: ₡").append(subtotal);
        factura.append("\nIVA 13%: ₡").append(iva);
        factura.append("\nTotal con IVA: ₡").append(totalConIVA);
        factura.append("\nDescuento: ₡").append(montoDescuento);
        factura.append("\n----------------------------------");
        factura.append("\nTOTAL FINAL A PAGAR: ₡").append(totalFinal);

        int resultadoDialogo = JOptionPane.showConfirmDialog(
                null,
                factura.toString() + "\n\n¿Desea realizar el pago de ₡" + totalFinal + "?",
                "Confirmar Pago",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (resultadoDialogo == JOptionPane.YES_OPTION) {
            pagarFactura();
        } else {
            anularFactura();
        }
    }

    
    // Calcular descuento
    
    /* este medoto tenemos un if para calcular el descuento si esta entre 10000 y 15000 se le hace 10% de descuento si el precio es 
    mayor a 15000 se le hace 15% de descuento 
    */
    private void calcularDescuento() {
        if (totalConIVA >= 10000 && totalConIVA <= 15000) {
            montoDescuento = totalConIVA * 0.10;
        } else if (totalConIVA > 15000) {
            montoDescuento = totalConIVA * 0.15;
        } else {
            montoDescuento = 0;
        }
        totalFinal = totalConIVA - montoDescuento;
    }

    
    // Obtener precio del producto
    // obtener precio del producto
    /* este metodo busca el nombre del producto en el arreglo y si lo encuentra
    devuelve el precio que le corresponde, si no devuelve 0 */

    private double obtenerPrecio(String producto) {
        for (int i = 0; i < nombresProducto.length; i++) {
            if (nombresProducto[i].equals(producto)) {
                return preciosProducto[i];
            }
        }
        return 0;
    }

    
    
    
    // proceso de pago
    /* este metodo pide el monto con el que paga el cliente, valida que sea suficiente,
    y si alcanza calcula el cambio y muestra un mensaje de pago exitoso */
   
    public void pagarFactura() {

        double montoIngresado = 0;
        boolean montoValido = false;

        while (!montoValido) {
            String entrada = JOptionPane.showInputDialog(
                    null,
                    "Total a pagar: " + totalFinal + "\n\nIngrese el monto con el que paga:",
                    "Pago",
                    JOptionPane.PLAIN_MESSAGE
            );

            if (entrada == null) {
                JOptionPane.showMessageDialog(null, "Operacion cancelada. No se realizo el pago.");
                return;
            }

            try {
                montoIngresado = Double.parseDouble(entrada);

                if (montoIngresado < totalFinal) {
                    JOptionPane.showMessageDialog(null, "El monto ingresado es menor al total. Intente de nuevo.");
                } else {
                    montoValido = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un numero valido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        double cambio = montoIngresado - totalFinal;

        JOptionPane.showMessageDialog(
                null,
                "Pago realizado con exito.\n" +
                "Monto ingresado: " + montoIngresado + "\n" +
                "Cambio: " + cambio + "\n" +
                "Gracias por su compra.");
    }
    
    
    public void anularFactura() {
        JOptionPane.showMessageDialog(null, "La factura ha sido anulada. No se realizo el cobro.");
    }



    // Getters y setters
    /* GETTERS Y SETTERS:
    * Se usan para encapsulamiento.
    * Esto significa proteger los atributos y cambiar su valor solo por medio de estos metodos.
    * Getter: devuelve el valor de un atributo.
    * Setter: cambia el valor de un atributo de forma controlada.*/
    public int getNumeroFactura() { return numeroFactura; }
    public void setNumeroFactura(int numeroFactura) { this.numeroFactura = numeroFactura; }

    public double getMontoFactura() { return montoFactura; }
    public void setMontoFactura(double montoFactura) { this.montoFactura = montoFactura; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public int getEmisionFactura() { return emisionFactura; }
    public void setEmisionFactura(int emisionFactura) { this.emisionFactura = emisionFactura; }

    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }

    public String getNombreColaborador() { return nombreColaborador; }
    public void setNombreColaborador(String nombreColaborador) { this.nombreColaborador = nombreColaborador; }

    public double getSubtotal() { return subtotal; }
    public double getIva() { return iva; }
    public double getTotalConIVA() { return totalConIVA; }
    public double getMontoDescuento() { return montoDescuento; }
    public double getTotalFinal() { return totalFinal; }
}
