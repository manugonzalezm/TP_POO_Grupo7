package model;/* Esta clase es abstracta */

public abstract class Comida {
    // Clase abstracta de comidas que hereda a las clases hijas (por tipo de comidas)

    /* Agregamos los atributos */
    public int id;
    public String nombre;
    public double precio;
    public boolean disponible;
    public String descripcion;
    public String tipo;

    // Constructor de la clase abstracta que será invocado por sus clases hijas
    public Comida(int id, String nombre, double precio, boolean disponible, String descripcion, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    /* Estos son los metodos getters */

    public int getId() { return id; }
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
    public void setId(int id) {
        this.id = id;
    }
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
    // Devuelve un String formateado para mostrar por pantalla al usuario los atributos de un objeto
    public String toString() {
        return "ID: " + id + "\t\tNombre: " + nombre + "\t\tPrecio: $" + precio + "\t\tDisponible: " +
                disponible + "\nDescripcion: " + descripcion + "\nTipo: " + tipo;

    }

    public String toStringArchivo() {
        // Se inicializa vacio para poder hacer un override en clases hijas
        return "";
    }

    public String toStringArchivoComida(String argumentos) {
        /* Convierte a String parseado para guardar el archivo (es invocado en las clases hijas y
         se concatena con los argumentos propios de cada una)
        */
        return (id + ";" + nombre + ";" + precio + ";" + disponible + ";" + descripcion + ";" + tipo + ";" + argumentos);
    }
}
