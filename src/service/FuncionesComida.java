package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class FuncionesComida {

    public static Comida parseComida(List<String> listaAtributos) {
        String nombre = listaAtributos.get(0);
        // Formateo de precio
        double precio = Double.parseDouble(listaAtributos.get(1));
        // Formateo de disponibilidad
        boolean disponible = Boolean.parseBoolean(listaAtributos.get(2));
        String descripcion = listaAtributos.get(3);
        // El quinto elemento indica el tipo de comida
        String tipo = listaAtributos.get(4);
        switch (tipo) {
            case "pizza":
                String queso = listaAtributos.get(5);
                String estilo = listaAtributos.get(6);
                boolean sinTacc = Boolean.parseBoolean(listaAtributos.get(7));
                // Instanciamos un objeto de la clase Pizza y lo agregamos a la lista de la carta de comidas
                return new Pizza(nombre, precio, disponible, descripcion, tipo, queso, estilo, sinTacc);
            case "postre":
                sinTacc = Boolean.parseBoolean(listaAtributos.get(5)); // se definio otra variable con el mismo nombre
                boolean paraCompartir = Boolean.parseBoolean(listaAtributos.get(6));
                // Instanciamos un objeto de la clase Postre y lo agregamos a la lista de la carta de comidas
                return new Postre(nombre, precio, disponible, descripcion, tipo, sinTacc, paraCompartir);
            case "hamburguesa":
                int cantPatys = Integer.parseInt(listaAtributos.get(5));
                boolean veggie = Boolean.parseBoolean(listaAtributos.get(6));
                String tipoPan = listaAtributos.get(7);
                String salsa = listaAtributos.get(8);
                // Usamos el método split para separar la cadena por comas
                String[] elementos = listaAtributos.get(9).split(",");
                // Creamos una lista para almacenar los elementos
                List<String> condimentos = new ArrayList<>();
                // Añadimos los elementos del arreglo a la lista
                for (String elemento : elementos) {
                    condimentos.add(elemento);
                }
                // Instanciamos un objeto de la clase Hamburguesa y lo agregamos a la lista de la carta de comidas
                return new Hamburguesa(nombre, precio, disponible, descripcion, tipo, cantPatys, veggie, tipoPan, salsa, condimentos);
            case "pasta":
                salsa = listaAtributos.get(5);
                boolean casero = Boolean.parseBoolean(listaAtributos.get(6));
                // Instanciamos un objeto de la clase Pasta y lo agregamos a la lista de la carta de comidas
                return new Pasta(nombre, precio, disponible, descripcion, tipo, salsa, casero);
            case "milanesa":
                // Usamos el método split para separar la cadena por comas
                String[] tamanios_elem = listaAtributos.get(5).split(",");
                // Creamos una lista para almacenar los elementos
                List<String> tamanios = new ArrayList<>();
                // Añadimos los elementos del arreglo a la lista
                for (String elemento : tamanios_elem) {
                    tamanios.add(elemento);
                }
                // Instanciamos un objeto de la clase Milanesa y lo agregamos a la lista de la carta de comidas
                return new Milanesa(nombre, precio, disponible, descripcion, tipo, tamanios);
            default:
                System.out.println("Error leyendo el tipo de comida.");
                return null;
        }
    }

}
