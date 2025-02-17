package model;

import java.util.List;

public class Milanesa extends Comida{
    public List<String> tamanios;

    // Constructor de la clase
    public Milanesa(String nombre, double precio, boolean disponible, String descripcion, String tipo, List<String> tamanios) {
        super(nombre, precio, disponible, descripcion, tipo);
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
}
