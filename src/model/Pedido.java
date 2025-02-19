package model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Pedido {
    public int idPedido;
    public String direccion;
    public String comentario;
    public Date horaPedido;
    public Date horaEstimada;
    public List contenido;
    public double propina;
    public double importe;
    public String medioPago;
    public String status;
    public String repAsignado;
    public String idCliente;

    //Constructor
    public Pedido(int idPedido, String direccion, String comentario, Date horaPedido, Date horaEstimada, List contenido,
                  double propina, double importe, String medioPago, String status, String repAsignado, String idCliente) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.comentario = comentario;
        this.horaPedido = horaPedido;
        this.horaEstimada = horaEstimada;
        this.contenido = contenido;
        this.propina = propina;
        this.importe = importe;
        this.medioPago = medioPago;
        this.status = status;
        this.repAsignado = repAsignado;
        this.idCliente = idCliente;
    }

    // Getters de la clase
    public int getIdPedido() {
        return idPedido;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getComentario() {
        return comentario;
    }
    public Date getHoraPedido() {
        return horaPedido;
    }
    public Date getHoraEstimada() {
        return horaEstimada;
    }
    public List getContenido() { return contenido; }
    public double getPropina() {
        return propina;
    }
    public double getImporte() {
        return importe;
    }
    public String getMedioPago() {
        return medioPago;
    }
    public String getStatus() {
        return status;
    }
    public String getRepAsignado() {
        return repAsignado;
    }
    public String getIdCliente() {
        return idCliente;
    }

    // Setters de la clase
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    public void setHoraPedido(Date horaPedido) {
        this.horaPedido = horaPedido;
    }
    public void setHoraEstimada(Date horaEstimada) {
        this.horaEstimada = horaEstimada;
    }
    public void setContenido(List contenido) {
        this.contenido = contenido;
    }
    public void setPropina(double propina) {
        this.propina = propina;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setRepAsignado(String repAsignado) {
        this.repAsignado = repAsignado;
    }
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    //toString
    @Override
    public String toString() {
        // Devuelve un String formateado para mostrar por pantalla al usaurio los atributos de un objeto
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // Formato para las fechas
        String contenidoStr = String.join("\t\t", contenido);  // Convierte la lista de contenido a un string separado por comas

        return String.format(
                "IdPedido: %d\tDireccion: %s\nComentario: %s\nHoraPedido: %s\tHoraEstimada: %s\nContenido: %s\nPropina: $%.2f\nImporte: $%.2f\nMedioPago: %s\nStatus: %s\nRepAsignado: %s\nIdCliente: %s",
                idPedido, direccion, comentario,
                sdf.format(horaPedido), sdf.format(horaEstimada),
                contenidoStr, propina, importe, medioPago, status, repAsignado, idCliente
        );
    }

    /* private String toStringContenido() {
        String contenidoString = "";
        for (int i = 0; i < contenido.size(); i++) {
            Object item = contenido.get(i);
            contenidoString = contenidoString +  + ";";
        }
        return contenidoString;
    } */

    public String toStringArchivo() {
        // Convierte a String parseado para guardar el archivo

        return idPedido + ";" + direccion + ";" + comentario + ";" + horaPedido + ";" + horaEstimada + ";" +
                contenido + ";" +  propina + ";" +  importe + ";" +  medioPago + ";" +  status + ";" +
                repAsignado + ";" +  idCliente;
    }
}
