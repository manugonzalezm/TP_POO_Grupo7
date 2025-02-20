package model;

public class Pizza extends Comida {
    // Clase hija de "Comida" que representa a las comidas de este tipo
    public String queso;
    public String estilo;
    public boolean sinTacc;

    // Constructor de la clase
    public Pizza(int id, String nombre, double precio, boolean disponible, String descripcion, String tipo,
                 String queso, String estilo, boolean sinTacc) {
        super(id, nombre, precio, disponible, descripcion, tipo);
        this.queso = queso;
        this.estilo = estilo;
        this.sinTacc = sinTacc;
    }

    // Getters
    public String getQueso() {
        return queso;
    }
    public String getEstilo() {
        return estilo;
    }
    public boolean isSinTacc() {
        return sinTacc;
    }

    // Setters
    public void setQueso(String queso) {
        this.queso = queso;
    }
    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
    public void setSinTacc(boolean sinTacc) {
        this.sinTacc = sinTacc;
    }

    // toString
    public String toString() {
        // Devuelve un String formateado para mostrar por pantalla al usuario los atributos de un objeto
        return super.toString() + "\t\tQueso: " + queso + "\t\tEstilo: " + estilo +  "\t\tSinTacc: " + sinTacc;
    }

    @Override
    public String toStringArchivo() {
        // Convierte a String parseado para guardar el archivo
        String argumentos = queso + ";" + estilo + ";" + sinTacc;
        return super.toStringArchivoComida(argumentos);
    }
}

