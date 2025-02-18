package model;

public class Postre extends Comida {
    public boolean sinTacc;
    public boolean paraCompartir;

    // Constructor de la clase
    public Postre(int id, String nombre, double precio, boolean disponible, String descripcion,
                  String tipo, boolean sinTacc, boolean paraCompartir) {
        super(id, nombre, precio, disponible, descripcion, tipo);
        this.sinTacc = sinTacc;
        this.paraCompartir = paraCompartir;
    }

    // Getters
    public boolean isSinTacc() {
        return sinTacc;
    }
    public boolean isParaCompartir() {
        return paraCompartir;
    }

    // Setters
    public void setSinTacc(boolean sinTacc) {
        this.sinTacc = sinTacc;
    }
    public void setParaCompartir(boolean paraCompartir) {
        this.paraCompartir = paraCompartir;
    }

    // toString
    public String toString() {
        return super.toString() + "\t\tSinTacc: " + sinTacc + "\t\tPara Compartir: " + paraCompartir;
        }
}
