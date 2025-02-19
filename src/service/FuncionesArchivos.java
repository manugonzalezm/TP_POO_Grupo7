package service;
import model.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static constants.Constantes.ARCHIVO_CARTA;
import static constants.Constantes.ARCHIVO_COMIDAS;
import static service.FuncionesComida.parseComida;

public class FuncionesArchivos {

    static String RUTA_BASE_ARCHIVOS =  "src/resources/";

    // Funcion que devuelve un booleano dependiendo de si el archivo pasado por parametro existe o no
    private static boolean existeArchivo(String rutaArchivo) {
        // Ruta del archivo a comprobar
        File archivo = new File(rutaArchivo);

        if(archivo.exists()) {
            return true;
        } else {
            return false;
        }
    }

    // Lee un archivo (pasado por parametro) de la carpeta src/resources
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

    // Escribe el archivo donde estan todos los platos
    public static void escribirArchivoMenu(String nuevoPlato) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_BASE_ARCHIVOS + ARCHIVO_COMIDAS , true))) {
            // El segundo parámetro 'true' permite agregar al archivo en lugar de sobrescribir
            // Añadir una nueva línea al archivo
            bw.write(nuevoPlato);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al escribir el archivo en " + RUTA_BASE_ARCHIVOS + ARCHIVO_COMIDAS);
        }
    }

    /*
    public void modificarArchivoMenu(String param, String nuevoValor, Scanner scanner) {
        List<String> lineas = new ArrayList<>();

         /*try {
            // Leer todas las líneas del archivo
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Verificamos si la línea contiene el nombre que estamos buscando
                if (linea.contains(lineaBusqueda)) {
                    // Si es la línea que buscamos, la reemplazamos
                    lineas.add(nuevaLinea);
                } else {
                    // Si no, agregamos la línea tal cual
                    lineas.add(linea);
                }
            }

        if (param == "precio"){

        } else if (param == "disponibilidad") {

        }
    }
    */

    // Crea un archivo en la carpeta src/resources y recibe como parametro el nombre del archivo
    public static void crearArchivo(String nombreArchivo) {
        // Ruta del archivo que queremos crear
        File archivo = new File(RUTA_BASE_ARCHIVOS + nombreArchivo);

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

    // Chequea si el archivo pasado como parametro existe y si no existe lo crea vacio
    public static void checkAndCreateFile(String nombreArchivo) {
        if (existeArchivo(RUTA_BASE_ARCHIVOS + nombreArchivo)) {
            // System.out.println("El archivo" + nombreArchivo + "ya existe");
        } else {
            crearArchivo(nombreArchivo);
            System.out.println("Se creó el archivo" + nombreArchivo + " porque no existia");
        }
    }

    // Lee el archivo de carta de platos
    public static List leerArchivoCarta() {
        List cartaComidas = new ArrayList();

        if (existeArchivo(RUTA_BASE_ARCHIVOS + ARCHIVO_COMIDAS)) {
            try (BufferedReader br = new BufferedReader(new FileReader(RUTA_BASE_ARCHIVOS + ARCHIVO_COMIDAS))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(";");
                    List<String> atributos = Arrays.asList(partes);
                    cartaComidas.add(parseComida(atributos));
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("Error al determinar existencia del archivo: " + RUTA_BASE_ARCHIVOS + ARCHIVO_COMIDAS);
        }

        return cartaComidas;
    }
}
