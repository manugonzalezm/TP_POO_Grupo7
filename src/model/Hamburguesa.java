package model;

import java.util.List;

public class Hamburguesa extends Comida{
    public int cantPatys;
    public boolean veggie;
    public String tipoPan;
    public String salsa;
    public List<String> condimentos;

    // Constructor de la clase
    public Hamburguesa(int id, String nombre, double precio, boolean disponible, String descripcion, String tipo, int cantPatys,
                       boolean veggie, String tipoPan, String salsa, List<String> condimentos) {
        super(id, nombre, precio, disponible, descripcion, tipo);
        this.cantPatys = cantPatys;
        this.veggie = veggie;
        this.tipoPan = tipoPan;
        this.salsa = salsa;
        this.condimentos = condimentos;
    }

    // Getters
    public int getCantPatys() {
        return cantPatys;
    }
    public boolean isVeggie() {
        return veggie;
    }
    public String getTipoPan() {
        return tipoPan;
    }
    public String getSalsa() {
        return salsa;
    }
    public List<String> getCondimentos() {
        return condimentos;
    }

    // Setters
    public void setCantPatys(int cantPatys) {
        this.cantPatys = cantPatys;
    }
    public void setVeggie(boolean veggie) {
        this.veggie = veggie;
    }
    public void setTipoPan(String tipoPan) {
        this.tipoPan = tipoPan;
    }
    public void setSalsa(String salsa) {
        this.salsa = salsa;
    }
    public void setCondimentos(List<String> condimentos) {
        this.condimentos = condimentos;
    }

    //toString
    public String toString() {

        return super.toString() + "CantPatys: " + cantPatys + "\t\tVeggie: " + veggie + "\t\tTipoPan: " + tipoPan + "\t\tSalsa: " + salsa + "\nCondimentos: " + condimentos;

    }
}
