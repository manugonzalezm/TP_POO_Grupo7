package model;

import java.util.List;

public class Milanesa extends Comida{
    public List<String> tamanios;

    // Constructor de la clase
    public Milanesa(int id, String nombre, double precio, boolean disponible, String descripcion, String tipo, List<String> tamanios) {
        super(id, nombre, precio, disponible, descripcion, tipo);
        this.tamanios = tamanios;
    }

    // Getters
    public List<String> getTamanios() {
        return tamanios;
    }

    // Setters
    public void setTamanios(List<String> tamanios) {
        this.tamanios = tamanios;
    }

    // toString
    public String toString() {
        return super.toString() + "\t\tTamaños: " + tamanios;
    }

    public String toStringArchivo() {
        return super.toStringArchivoComida() + String.join(";", tamanios);
    }
}
