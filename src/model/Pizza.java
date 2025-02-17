package model;

public class Pizza extends Comida {
    public String queso;
    public String estilo;
    public boolean sinTacc;

    // Constructor de la clase
    public Pizza(String nombre, double precio, boolean disponible, String descripcion, String tipo,
                 String queso, String estilo, boolean sinTacc) {
        super(nombre, precio, disponible, descripcion, tipo);
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
        return super.toString() + "Queso: " + queso + "\t\tEstilo: " + estilo +  "\t\tSinTacc: " + sinTacc;

    }
}

