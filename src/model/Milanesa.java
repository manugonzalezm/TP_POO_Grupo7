package model;

import java.util.List;

public class Milanesa extends Comida{
    // Clase hija de "Comida" que representa a las comidas de este tipo
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
    // Devuelve un String formateado para mostrar por pantalla al usuario los atributos de un objeto
    public String toString() {
        return super.toString() + "\t\tTamaños: " + tamanios;
    }

    @Override
    public String toStringArchivo() {
        // Convierte a String parseado para guardar el archivo
        String argumentos = String.join(";", tamanios);
        return super.toStringArchivoComida(argumentos);
    }
}
