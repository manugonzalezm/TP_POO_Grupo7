package model;/* Esta clase es abstracta */

public abstract class Comida {
    /* Agregamos los atributos */

    public String nombre;
    public double precio;
    public boolean disponible;
    public String descripcion;
    public String tipo;

    // Constructor de la clase abstracta que será invocado por sus clases hijas
    public Comida(String nombre, double precio, boolean disponible, String descripcion, String tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /* Estos son los metodos getters */
    public String getNombre() {
        return nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public boolean getDisponible() {
        return disponible;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String getTipo() {
        return tipo;
    }

    /* Estos son los metodos setters */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // toString
    public String toString() {
        return "Nombre: " + nombre + "\t\tPrecio: $" + precio + "\t\tDisponible: " + disponible + "\t\tDescripcion: " + descripcion + "\nTipo: " + tipo;

    }
}
