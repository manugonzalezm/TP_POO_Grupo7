package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    // Clase que representa al cliente que hace el pedido

    private String idCliente;
    public String telefono;
    public int cantPedidos;
    public List<Pedido> pedidosHechos;

    public Cliente(String idCliente, String telefono, String direccion, int cantPedidos) {
        this.idCliente = idCliente;
        this.telefono = telefono;
        this.cantPedidos = cantPedidos;
        pedidosHechos = new ArrayList<Pedido>();
    }

    // Getters de la clase
    public String getIdCliente() {
        return idCliente;
    }
    public String getTelefono() {
        return telefono;
    }
    public int getCantPedidos() {
        return cantPedidos;
    }
    public List<Pedido> getPedidosHechos() {
        return pedidosHechos;
    }

    // Setters de la clase
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setCantPedidos(int cantPedidos) {
        this.cantPedidos = cantPedidos;
    }
    public void setPedidosHechos(List<Pedido> pedidosHechos) {
        this.pedidosHechos = pedidosHechos;
    }

    //toString
    // Devuelve un String formateado para mostrar por pantalla al usuario los atributos de un objeto
    public String toString() {
        return super.toString() + "IdCliente: " + idCliente + "\t\tTelefono: " + telefono + "\t\tCantPedidos: " + cantPedidos + "\t\tPedidos: " + pedidosHechos;
    }
}
