package model;

import java.util.List;

public class Empleado {
    private String nombre;
    private String legajo;
    private int cantPedidos;

    // Constructor de la clase
    public Empleado(String nombre, String legajo, int cantPedidos){
        this.nombre = nombre;
        this.legajo = legajo;
        this.cantPedidos = cantPedidos;
    }

    // Getters
    private String getNombre() {
        return nombre;
    }
    private String getLegajo() {
        return legajo;
    }
    private int getCantPedidos() {
        return cantPedidos;
    }

    // Setters
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private void setLegajo(String legajo) {
        this.legajo = legajo;
    }
    private void setCantPedidos(int cantPedidos) {
        this.cantPedidos = cantPedidos;
    }

    //Metodos a ejecutar por el empleado que gestiona el sistema

    //
    private void cambiarEstadoPedido(Pedido pedido, String nuevoEstado) {

    }

    //
    private void asignaPedidoRep(Pedido pedido, String idRepartidor){

    }

    //
    private void generarReporteDia() {

    }

    //
    private void generarReporteMes() {

    }

    //
    private void altaPlato(Comida plato) {
        //armar switch de tipos de plato para cada clase
    }

    //
    private void bajaPlato(Comida plato) {
        //armar switch de tipos de plato para cada clase
    }

    //
    private void editPlato(Comida plato) {
        //armar switch de tipos de plato para cada clase
    }

    //
    private List verMenu() {
        return null; // return temporario hasta tener logica de codigo
    }

    //
    private List<Pedido> verPedidos() {
        return null; // return temporario hasta tener logica de codigo
    }

    //
    private Pedido verPedidoPorId(int idPedido) {
        return null; // return temporario hasta tener logica de codigo
    }

    //
    private Cliente verClienteByPedido () {
        return null; // return temporario hasta tener logica de codigo
    }

    //
    private List<Repartidor> verRepartidores() {
        return null; // return temporario hasta tener logica de codigo
    }

}
