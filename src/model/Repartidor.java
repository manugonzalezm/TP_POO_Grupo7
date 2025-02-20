package model;

import java.text.SimpleDateFormat;
import java.util.List;

public class Repartidor {
    // Clase que representa al repartidor, cada pedido tiene un repartidor asignado

    /* Agregamos los atributos */
    public String idRepartidor;
    public int cantPedidos = 0;
    public List<Pedido> pedidos;
    public boolean activo;

    /* Hacemos el constructor */
    public Repartidor (String idRepartidor, int cantPedidos, List<Pedido> pedidos, boolean activo) {
        this.idRepartidor = idRepartidor;
        this.cantPedidos = cantPedidos;
        this.pedidos = pedidos;
        this.activo = activo;
    }

    /* Estos son los metodos getters */
    public String getIdRepartidor() {
        return idRepartidor;
    }
    public int getCantPedidos() {
        return cantPedidos;
    }
    public List<Pedido> getPedidos() {
        return pedidos;
    }
    public boolean getActivo() {
        return activo;
    }

    /* Estos son los metodos setters */
    public void setIdRepartidor(String idRepartidor) {
        this.idRepartidor = idRepartidor;
    }
    public void setCantPedidos(int cantPedidos) {
        this.cantPedidos = cantPedidos;
    }
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Funcion que devuelve como String los atributos del repartidor para mostrar por consola
    public String toString() {
        return (idRepartidor + ";" + cantPedidos + ";" + pedidos + ";" + activo);
    }
}
