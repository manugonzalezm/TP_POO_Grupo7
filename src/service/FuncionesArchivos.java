package service;
import model.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static constants.Constantes.ARCHIVO_CARTA;

public class FuncionesArchivos {

    private static String RUTA_BASE_ARCHIVOS = "/Users/manuelgonzalezmourino/Documents/GitHub/TP_POO_Grupo7/src/resources/";

    private static boolean existeArchivo(String rutaArchivo) {
        // Ruta del archivo a comprobar
        File archivo = new File(rutaArchivo);

        if(archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public static void leerArchivo(String rutaArchivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void escribirArchivo(String rutaArchivo) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + rutaArchivo, true))) {
            // El segundo parámetro 'true' permite agregar al archivo en lugar de sobrescribir
            bw.write("Esto es una línea añadida al archivo.");
            bw.newLine();  // Añadir una nueva línea al archivo
            bw.write("Otra línea de texto.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivo(String nombreArchivo, String formato) {
        // Ruta del archivo que queremos crear
        File archivo = new File(RUTA_BASE_ARCHIVOS + nombreArchivo + formato);

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List leerArchivoCarta() {
        String rutaArchivo = ARCHIVO_CARTA;
        List cartaComidas = new ArrayList();

        if (existeArchivo(rutaArchivo)) {
            try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    String nombre = partes[0];
                    // Formateo de precio
                    double precio = Double.parseDouble(partes[1]);
                    // Formateo de disponibilidad
                    boolean disponible = Boolean.parseBoolean(partes[2]);
                    String descripcion = partes[3];
                    // El quinto elemento indica el tipo de comida
                    String tipo = partes[4];
                    switch (tipo) {
                        case "pizza":
                            String queso = partes[5];
                            String estilo = partes[6];
                            boolean sinTacc = Boolean.parseBoolean(partes[7]);
                            // Instanciamos un objeto de la clase Pizza y lo agregamos a la lista de la carta de comidas
                            cartaComidas.add(new Pizza(nombre, precio, disponible, descripcion, tipo, queso, estilo, sinTacc));
                            break;
                        case "postre":
                            sinTacc = Boolean.parseBoolean(partes[5]); // se definio otra variable con el mismo nombre
                            boolean paraCompartir = Boolean.parseBoolean(partes[6]);
                            // Instanciamos un objeto de la clase Postre y lo agregamos a la lista de la carta de comidas
                            cartaComidas.add(new Postre(nombre, precio, disponible, descripcion, tipo, sinTacc, paraCompartir));
                            break;
                        case "hamburguesa":
                            int cantPatys = Integer.parseInt(partes[5]);
                            boolean veggie = Boolean.parseBoolean(partes[6]);
                            String tipoPan = partes[7];
                            String salsa = partes[8];
                            List condimentos = List.of(partes[9]);
                            // Instanciamos un objeto de la clase Hamburguesa y lo agregamos a la lista de la carta de comidas
                            cartaComidas.add(new Hamburguesa(nombre, precio, disponible, descripcion, tipo, cantPatys, veggie, tipoPan, salsa, condimentos));
                            break;
                        case "pasta":
                            salsa = partes[5];
                            boolean casero = Boolean.parseBoolean(partes[6]);
                            // Instanciamos un objeto de la clase Pasta y lo agregamos a la lista de la carta de comidas
                            cartaComidas.add(new Pasta(nombre, precio, disponible, descripcion, tipo, salsa, casero));
                            break;
                        case "milanesa":
                            List tamanios = List.of(partes[5]);
                            // Instanciamos un objeto de la clase Milanesa y lo agregamos a la lista de la carta de comidas
                            cartaComidas.add(new Milanesa(nombre, precio, disponible, descripcion, tipo, tamanios));
                            break;
                        default:
                            System.out.println("Error leyendo el tipo de comida.");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("Error al leer el archivo: " + RUTA_BASE_ARCHIVOS + rutaArchivo);
        }


        return cartaComidas;
    }
}
