package service;

import model.*;

import java.io.*;
import java.util.*;

import static constants.Constantes.*;
import static service.FuncionesArchivos.RUTA_BASE_ARCHIVOS;
import static service.FuncionesArchivos.escribirArchivoMenu;
import static service.FuncionesMenu.pedirInput;

public class FuncionesComida {

    // Funcion que recibe una lista de Strings como atributos y instancia de la clase Comida
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

        //Dependiendo del tipo de comida utiliza mas o menos atributos y de distinto tipo de dato:
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

    // Funcion que recibe una lista de Strings como atributos y el scanner por donde el usuario ingresa los valores del plato
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
        // Dependiendo del tipo de Comida pide determinados campos
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
        escribirArchivoMenu(String.join(";", atributos));
        return atributos;
    }

    /*
    // Cambiar el precio o disponibilidad de un Plato específico
    public static List editPlato(Scanner scanner, List<Comida> listaComidas, String valorEdit) {
        System.out.println("Ingrese el ID del plato:");
        int idPlato = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        // Leer todos los pedidos
        boolean encontrado = false;

        // Modificar el estado de un plato específico
        for (Comida plato : listaComidas) {
            if (plato.getId() == idPlato) {
                if(valorEdit.equals("precio")) {
                    System.out.println("El precio actual del plato: " + idPlato + "- " + plato.getNombre() + " es: " + plato.getPrecio());
                    System.out.println("Ingrese el nuevo precio: ($)");
                    String valorPrecio = scanner.nextLine();
                    plato.setPrecio(Double.parseDouble(valorPrecio));
                } else if(valorEdit.equals("disponible")) {
                    System.out.println("La disponibilidad actual del plato: " + idPlato + "- " + plato.getNombre() + " es: " + (plato.getDisponible() ? "Disponible" : "No disponible"));
                    System.out.println("Cambiando a " + (!plato.getDisponible() ? " Disponible..." : "No disponible..."));
                    plato.setDisponible(!plato.getDisponible());
                } else {
                    break;
                }

                encontrado = true;
                break;  // Sale del bucle cuando encuentra el pedido
            }
        }

        if (encontrado) {
            // Guardar los cambios en el archivo
            guardarPlatos(listaComidas);
            System.out.println("Estado del pedido actualizado correctamente.");
            return listaComidas;
        } else {
            System.out.println("Pedido no encontrado.");
            return listaComidas;
        }
    }
     */

    // Guardar los platos en el archivo después de cualquier modificación
    private static void guardarPlatos(List<Comida> platos) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_CARTA))) {
            for (Comida plato : platos) {
                bw.write(plato.toStringArchivo());  // Escribe cada plato
                bw.newLine();  // Añade una nueva línea
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar los platos.");
        }
    }


}
