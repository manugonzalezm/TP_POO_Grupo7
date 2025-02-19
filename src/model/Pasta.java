package model;

public class Pasta extends Comida{
    public String salsa;
    public boolean casero;

    // Constructor de la clase
    public Pasta(int id, String nombre, double precio, boolean disponible, String descripcion, String tipo, String salsa, boolean casero) {
        super(id,nombre, precio, disponible, descripcion, tipo);
        this.salsa = salsa;
        this.casero = casero;
    }

    // Getters
    public String getSalsa() {
        return salsa;
    }
    public boolean isCasero() {
        return casero;
    }

    // Setters
    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
    public void setCasero(boolean casero) {
        this.casero = casero;
    }

    // toString
    public String toString() {
        return super.toString() + "\t\tSalsa: " + salsa + "\t\tCasero: " + casero;
    }

    @Override
    public String toStringArchivo() {
        String argumentos = salsa + ";" + casero;
        return super.toStringArchivoComida(argumentos);
    }
}
