package service;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static service.FuncionesMenu.pedirInput;

public class FuncionesComida {

    public static Comida parseComida(List<String> listaAtributos) {
        int id = Integer.parseInt(listaAtributos.get(0));
        String nombre = listaAtributos.get(1);
        // Formateo de precio
        double precio = Double.parseDouble(listaAtributos.get(2));
        // Formateo de disponibilidad
        boolean disponible = Boolean.parseBoolean(listaAtributos.get(3));
        String descripcion = listaAtributos.get(4);
        // El quinto elemento indica el tipo de comida
        String tipo = listaAtributos.get(5);
        switch (tipo) {
            case "pizza":
                String queso = listaAtributos.get(6);
                String estilo = listaAtributos.get(7);
                boolean sinTacc = Boolean.parseBoolean(listaAtributos.get(8));
                // Instanciamos un objeto de la clase Pizza y lo agregamos a la lista de la carta de comidas
                return new Pizza(id, nombre, precio, disponible, descripcion, tipo, queso, estilo, sinTacc);
            case "postre":
                sinTacc = Boolean.parseBoolean(listaAtributos.get(6)); // se definio otra variable con el mismo nombre
                boolean paraCompartir = Boolean.parseBoolean(listaAtributos.get(7));
                // Instanciamos un objeto de la clase Postre y lo agregamos a la lista de la carta de comidas
                return new Postre(id, nombre, precio, disponible, descripcion, tipo, sinTacc, paraCompartir);
            case "hamburguesa":
                int cantPatys = Integer.parseInt(listaAtributos.get(6));
                boolean veggie = Boolean.parseBoolean(listaAtributos.get(7));
                String tipoPan = listaAtributos.get(8);
                String salsa = listaAtributos.get(9);
                // Usamos el método split para separar la cadena por comas
                String[] elementos = listaAtributos.get(10).split(",");
                // Creamos una lista para almacenar los elementos
                List<String> condimentos = new ArrayList<>();
                // Añadimos los elementos del arreglo a la lista
                for (String elemento : elementos) {
                    condimentos.add(elemento);
                }
                // Instanciamos un objeto de la clase Hamburguesa y lo agregamos a la lista de la carta de comidas
                return new Hamburguesa(id, nombre, precio, disponible, descripcion, tipo, cantPatys, veggie, tipoPan, salsa, condimentos);
            case "pasta":
                salsa = listaAtributos.get(6);
                boolean casero = Boolean.parseBoolean(listaAtributos.get(7));
                // Instanciamos un objeto de la clase Pasta y lo agregamos a la lista de la carta de comidas
                return new Pasta(id, nombre, precio, disponible, descripcion, tipo, salsa, casero);
            case "milanesa":
                // Usamos el método split para separar la cadena por comas
                String[] tamanios_elem = listaAtributos.get(6).split(",");
                // Creamos una lista para almacenar los elementos
                List<String> tamanios = new ArrayList<>();
                // Añadimos los elementos del arreglo a la lista
                for (String elemento : tamanios_elem) {
                    tamanios.add(elemento);
                }
                // Instanciamos un objeto de la clase Milanesa y lo agregamos a la lista de la carta de comidas
                return new Milanesa(id, nombre, precio, disponible, descripcion, tipo, tamanios);
            default:
                System.out.println("Error leyendo el tipo de comida.");
                return null;
        }
    }

    public static List<String> crearPlato(List<String> atributos, Scanner scanner) {
        // ID autogenerado
        Random random = new Random();
        int idRandom = random.nextInt(9000) + 1000;
        atributos.add(String.valueOf(idRandom));

        System.out.println("ALTA DE NUEVO PLATO: ");
        System.out.println("INGRESE EL NOMBRE: ");
        atributos.add(pedirInput(scanner));
        System.out.println("INGRESE EL PRECIO: (888.88)");
        atributos.add(pedirInput(scanner));
        System.out.println("INGRESE LA DISPONIBILIDAD: (Y/N)");
        atributos.add(pedirInput(scanner).toUpperCase().equals("Y") ? "true" : "false");
        System.out.println("INGRESE LA DESCRIPCION: ");
        atributos.add(pedirInput(scanner));
        System.out.println("INGRESE LA CATEGORIA DE PLATO: ");
        String input = scanner.nextLine();
        atributos.add(input);
        switch(input) {
            case "pizza":
                System.out.println("INGRESE EL TIPO DE QUESO: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE EL ESTILO: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE SI ES SIN-TACC: (Y/N)");
                atributos.add(pedirInput(scanner).toUpperCase().equals("Y") ? "true" : "false");
                break;
            case "postre":
                System.out.println("INGRESE SI ES SIN-TACC: (Y/N): ");
                atributos.add(pedirInput(scanner).toUpperCase().equals("Y") ? "true" : "false");
                System.out.println("INGRESE SI ES PARA COMPARTIR (Y/N): ");
                atributos.add(pedirInput(scanner).toUpperCase().equals("Y") ? "true" : "false");
                break;
            case "hamburguesa":
                System.out.println("INGRESE CANTIDAD DE PATYS: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE SI ES VEGGIE (Y/N): ");
                atributos.add(pedirInput(scanner).toUpperCase().equals("Y") ? "true" : "false");
                System.out.println("INGRESE TIPO DE PAN: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE LA SALSA: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE LOS CONDIMENTOS SEPARADOS POR COMA: ");
                atributos.add(pedirInput(scanner));
                break;
            case "pasta":
                System.out.println("INGRESE LA SALSA: ");
                atributos.add(pedirInput(scanner));
                System.out.println("INGRESE SI ES CASERO: (Y/N)");
                atributos.add(pedirInput(scanner).toUpperCase()=="Y" ? "true" : "false");
                break;
            case "milanesa":
                System.out.println("INGRESE LOS TAMAÑOS DISPONIBLES SEPARADOS POR COMA: ");
                atributos.add(pedirInput(scanner));
                break;
            default:
                System.out.println("Error leyendo el tipo de comida.");

        }
        return atributos;
    }

}
